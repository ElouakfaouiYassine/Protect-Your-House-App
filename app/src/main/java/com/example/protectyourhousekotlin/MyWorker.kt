package com.example.protectyourhousekotlin


import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.util.*

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.BatteryManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker (context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        val isCharging = isChargerConnected()
        val batteryLevel = getBatteryLevel()
        if (isCharging) {
            if (batteryLevel == 100) {
                showNotification()
                playAlertSound()
            }
        }
        return Result.success()
    }

    private fun isChargerConnected(): Boolean {
        val intent = applicationContext.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        val status = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
        return status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL
    }
    private fun getBatteryLevel(): Int {
        val intent = applicationContext.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        return intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0) ?: 0
    }

    private fun showNotification() {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel = NotificationChannel(
            "channel_id",
            "Channel Name",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)

        val notificationBuilder = NotificationCompat.Builder(applicationContext, "channel_id")
            .setSmallIcon(R.drawable.iconsbattery)
            .setContentTitle("Protect Your House")
            .setContentText("In order to avoid fires and protect your home you must disconnect the charger from the phone")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ContextCompat.getColor(applicationContext, R.color.colortest))
            .setAutoCancel(true)

        val notificationId = Random().nextInt(1000)
        notificationManager.notify(notificationId, notificationBuilder.build())
    }


    private fun playAlertSound() {
        try {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.electric_son)
            mediaPlayer.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }





}