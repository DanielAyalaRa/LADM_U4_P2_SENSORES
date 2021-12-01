package mx.tecm.tepic.ladm_u2_p2_canvas_sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    var Lienzo : Focos ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_NORMAL)

        Lienzo = Focos(this)
        setContentView(Lienzo)
    }

    override fun onSensorChanged(evento: SensorEvent?) {
        if(evento!!.sensor.type == Sensor.TYPE_ACCELEROMETER){
            Lienzo!!.fiesta = (evento.values[0]>=1f)
        }
        if(evento!!.sensor.type == Sensor.TYPE_PROXIMITY){
            Lienzo!!.dia = (evento.values[0]>=1f)
        }
        Lienzo?.invalidate()
    }

    override fun onAccuracyChanged(evento: Sensor?, p1: Int) {

    }
}