package com.bluemoon.gradledemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Looper
import android.os.MessageQueue
import android.util.AttributeSet
import android.util.Log

/**
 * Created by CHEN on 2022/8/16.
 */
@SuppressLint("AppCompatCustomView")
open class MonitorImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : android.widget.ImageView(context, attrs, defStyleAttr), MessageQueue.IdleHandler {

    companion object {
        private const val MAX_ALARM_IMAGE_SIZE = 1024 * 1024
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        startDetect()
    }

    override fun setImageBitmap(bm: Bitmap?) {
        super.setImageBitmap(bm)
        startDetect()
    }

    private fun startDetect() {
        Looper.myQueue().removeIdleHandler(this)
        Looper.myQueue().addIdleHandler(this)
    }

    override fun queueIdle(): Boolean {
        analyzeImage()
        return false
    }

    private fun analyzeImage() {
        val mDrawable = drawable ?: return
        val drawableWidth = mDrawable.intrinsicWidth
        val drawableHeight = mDrawable.intrinsicHeight
        val viewWidth = measuredWidth
        val viewHeight = measuredHeight
        val imageSize = calculateImageSize(mDrawable)
        if (imageSize > MAX_ALARM_IMAGE_SIZE) {
            Log.w(">>>CHEN>>>", "${javaClass.canonicalName}:" + "id=${id},图片大小超标 -> $imageSize")
        }
        if (drawableWidth > viewWidth || drawableHeight > viewHeight) {
            Log.w(">>>CHEN>>>", "${javaClass.canonicalName}:" + "id=${id},图片尺寸超标 -> drawable：$drawableWidth x $drawableHeight  view：$viewWidth x $viewHeight")
        }
    }

    private fun calculateImageSize(drawable: Drawable): Int {
        return when (drawable) {
            is BitmapDrawable -> {
                drawable.bitmap.byteCount
            }
            else -> {
                0
            }
        }
    }
}