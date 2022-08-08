package com.bluemoon.gradledemo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Child().call()
         try {
            val telePhonyMgr = getSystemService("phone") as TelephonyManager
            telePhonyMgr.deviceId

        } catch (var2: Exception) {
            ""
        }

    }

    fun onTab(view: View) {
        (view as TextView).text = DeviceUtils.getBrand()
    }
}