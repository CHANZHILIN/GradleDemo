package com.bluemoon.gradledemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet

/**
 * Created by CHEN on 2022/8/16.
 */
@SuppressLint("AppCompatCustomView")
open class CustomImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : android.widget.ImageView(context, attrs, defStyleAttr)