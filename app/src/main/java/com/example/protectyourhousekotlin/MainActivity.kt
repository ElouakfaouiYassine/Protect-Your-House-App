package com.example.protectyourhousekotlin

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit
import androidx.work.WorkInfo
import com.example.protectyourhousekotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myWorkRequest = PeriodicWorkRequestBuilder<MyWorker>(1, TimeUnit.DAYS).build()

        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(myWorkRequest)

        workManager.getWorkInfoByIdLiveData(myWorkRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                }
            })
        registerReceiver()
    }

    private fun registerReceiver() {
        registerReceiver(batteryInfoReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    private var batteryInfoReceiver : BroadcastReceiver = object : BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        override fun onReceive(context: Context?, intent: Intent?) {

            val batteryLevel = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
            val batteryIsCharging = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
            val batteryTemperature = intent?.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)?.div(10)
            val batteryVoltage = intent?.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0)?.div(1000)
            val batteryTechnology = intent?.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)

            binding.apply {
                batteryLevel?.let {
                    batteryProgress.setProgress(100 - it)
                    tvBatteryLevel.text = "$batteryLevel%"
                }
                batteryIsCharging.let {
                    if (batteryIsCharging == 0) tvPlugInValue.text = "OFF"
                    else tvPlugInValue.text = "ON"
                }
                batteryVoltage.let {
                    tvVoltageValue.text = batteryVoltage.toString() + " V"
                }
                batteryTemperature.let {
                    tvTemperatureValue.text = "$batteryTemperature C"
                }
                batteryTechnology.let {

                    tvTechnologyValue.text = batteryTechnology.toString()
                }
            }
        }

    }

}
