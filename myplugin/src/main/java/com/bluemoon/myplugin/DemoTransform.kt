package com.bluemoon.myplugin

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.FileOutputStream

/**
 * Created by CHEN on 2022/7/7.
 */
class DemoTransform : Plugin<Project>, Transform() {

    companion object {
        val USE_ASM = "useAsm"
        val NAME_DOMAIN = "envConfig"
    }

    override fun apply(project: Project) {
        println(">>>CHEN>>> this is a log just from DemoTransform")
        val appExtension = project.extensions.getByType(AppExtension::class.java)
        appExtension.registerTransform(this)
        applyExtension(project)
        applyMavenFeature(project)
    }


    override fun getName(): String {
        return "KotlinDemoTransform"
    }

    /**
     * ContentType，数据类型，有CLASSES和RESOURCES两种。
     * 其中的CLASSES包含了源项目中的.class文件和第三方库中的.class文件。
     * RESOURCES仅包含源项目中的.class文件。
     * 对应getInputTypes() 方法
     */
    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    /**
     * Scope，表示要处理的.class文件的范围，主要有
     * PROJECT， SUB_PROJECTS，EXTERNAL_LIBRARIES等。
     * 对应getScopes() 方法。
     */
    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
        //inputs 中传过来的输入流，其中有两种格式，一种是jar包，一种是目录格式
        val inputs = transformInvocation?.inputs
        //获取到输出目录，最后将修改的文件复制到输出目录，这一步必须做，不然编译报错
        val outputProvider = transformInvocation?.outputProvider

        if (!isIncremental) {
            outputProvider?.deleteAll()
        }
        inputs?.forEach { it ->
            it.directoryInputs.forEach {
                println(">>>CHEN>>> ${it.file.absolutePath}")
                if (it.file.isDirectory) {
                    FileUtils.getAllFiles(it.file).forEach {
                        val file = it
                        val name = file.name
                        //1.过滤其他不合符条件的class文件
                        if (name.endsWith(".class") && name != ("R.class")
                            && !name.startsWith("R\$") && name != ("BuildConfig.class")
                        ) {

                            val classPath = file.absolutePath
                            println(">>>CHEN>>> classPath :$classPath")
                            //2.ClassReader读取并解析class文件
                            val cr = ClassReader(file.readBytes())
                            //构建一个ClassWriter对象，并设置让系统自动计算栈和本地变量大小
                            val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)
                            //3.经由我们编写的ClassVisitor和MethodVisitor处理
                            val visitor = ChildClassVisitor(cw)
                            //开始扫描class文件
                            cr.accept(visitor, ClassReader.EXPAND_FRAMES)

                            //4.通过FileOutputStream将新的字节码内容写回到class文件
                            val bytes = cw.toByteArray()
                            val fos = FileOutputStream(classPath)
                            fos.write(bytes)
                            fos.close()
                        }
                    }
                }

                val dest = outputProvider?.getContentLocation(
                    it.name,
                    it.contentTypes,
                    it.scopes,
                    Format.DIRECTORY
                )
                FileUtils.copyDirectoryToDirectory(it.file, dest)

            }

            //使用androidx的项目一定也注意jar也需要处理，否则所有的jar都不会最终编译到apk中，千万注意
            //导致出现ClassNotFoundException的崩溃信息，当然主要是因为找不到父类，因为父类AppCompatActivity在jar中
            it.jarInputs.forEach {
                val dest = outputProvider?.getContentLocation(
                    it.name,
                    it.contentTypes,
                    it.scopes,
                    Format.JAR
                )
                FileUtils.copyFile(it.file, dest)
            }

        }
    }

    private fun applyExtension(project: Project) {
        // 创建扩展，并添加到 ExtensionContainer
        project.extensions.create(USE_ASM, UseAsm::class.java)
        project.extensions.create(NAME_DOMAIN, EnvConfigExtension::class.java, project)
    }

    private fun applyMavenFeature(project: Project) {
        project.afterEvaluate {
            //自定义拓展字段
            val rootConfig = UseAsm.getConfig(project)
            println(">>>CHEN>>> Config:projectName=${project.name},useAsmToApplication=${rootConfig.useAsmToApplication}")
            println(">>>CHEN>>> Config:tryCatch=uploadToService=${rootConfig.configService.uploadToService},uploadServiceAddress=${rootConfig.configService.serviceAddress}")
            //自定义拓展字段 NamedDomainObjectContainer
            val domainConfig = EnvConfigExtension.getNamedDomainExtensionConfig(project)
            domainConfig.services.all {
                println(">>>CHEN>>> servicesConfig = $it")
            }
        }
    }

}
