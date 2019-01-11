package com.example.android.myapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vManager = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val sManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var s: Sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sManager.registerListener(object : SensorEventListener {
            override fun onSensorChanged(pos: SensorEvent?) {
                var values = pos?.values
                textView.text = "X value:${values!![0]}"
                textView2.text = "Y value:${values!![1]}"
                if (values[0] > 4 || values[1] > 4) {
                    vManager.vibrate(2000L)
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }
        }, s, SensorManager.SENSOR_DELAY_NORMAL)
    }



}


