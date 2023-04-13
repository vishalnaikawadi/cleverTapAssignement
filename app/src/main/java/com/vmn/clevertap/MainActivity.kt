package com.vmn.clevertap

import android.os.Build
import android.os.Bundle
import android.util.Log.VERBOSE
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.clevertap.android.sdk.CleverTapAPI

class MainActivity : AppCompatActivity(), EventListener by EventImpl() {

    private val cleverTapDefaultInstance by lazy {
        CleverTapAPI.getDefaultInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CleverTapAPI.setDebugLevel(VERBOSE)
        sendUserDetails(cleverTapDefaultInstance)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Utils.createNotificationChannel(applicationContext)
        }

        findViewById<Button>(R.id.btnClickMe).setOnClickListener {
            sendEventProductViewed(cleverTapDefaultInstance)
        }
    }
}