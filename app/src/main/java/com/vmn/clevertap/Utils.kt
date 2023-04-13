package com.vmn.clevertap

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.clevertap.android.sdk.CleverTapAPI

object Utils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(appContext: Context) {
        CleverTapAPI.createNotificationChannel(
            appContext,
            "GET",
            "GET",
            "Targeted users",
            NotificationManager.IMPORTANCE_MAX,
            true
        )
    }


}

