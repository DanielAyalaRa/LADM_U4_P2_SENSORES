package mx.tecm.tepic.ladm_u2_p2_canvas_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Focos (act:MainActivity): View(act) {
    val principal = act

    //Imagenes
    val apagado = BitmapFactory.decodeResource(principal.resources,R.drawable.apagado)
    val encendido = BitmapFactory.decodeResource(principal.resources,R.drawable.encendido)
    val encendido_color = BitmapFactory.decodeResource(principal.resources,R.drawable.encendidoazul)
    val fondo1 = BitmapFactory.decodeResource(principal.resources,R.drawable.fondoterror)
    val fondo2 = BitmapFactory.decodeResource(principal.resources,R.drawable.disco)
    val fondo = BitmapFactory.decodeResource(principal.resources,R.drawable.principal)
    val fantasma = Imagen(this, 200f, 1200f, R.drawable.velita)

    //variables de control
    var dia = true
    var fiesta = false

    val movFantasma = object: CountDownTimer(3000,8000){

        override fun onTick(p0: Long) {
            repintar()
            invalidate()    //forzamos al ondraw a volver a pintarse
        }

        override fun onFinish() {
            //aqui va el start que vuelve a ejecutar
            start()
        }
    }

    init{
        movFantasma.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        canvas.drawBitmap(fondo,0f,0f,paint)

        //Focos apagados
        canvas.drawBitmap(apagado,20f,100f,paint)
        canvas.drawBitmap(apagado,360f,100f,paint)
        canvas.drawBitmap(apagado,700f,100f,paint)

        //Focos Encendidos
        if(dia == false) {
            canvas.drawBitmap(fondo1,0f,0f,paint)
            canvas.drawBitmap(encendido,360f,100f,paint)
            //nube
            paint.color = Color.LTGRAY
            canvas.drawOval(450f,950f,600f,900f, paint )
            paint.color = Color.LTGRAY
            canvas.drawOval(20f,100f,260f,150f, paint )
            canvas.drawOval(225f,120f,455f,160f, paint )
            paint.color = Color.LTGRAY
            canvas.drawOval(460f,979f,220f,900f, paint )
            canvas.drawOval(550f,1250f,700f,1200f, paint )
            paint.color = Color.LTGRAY
            canvas.drawOval(860f,1279f,620f,1200f, paint )

        }

        //Focos Encendidos de color azul
        if(fiesta == true) {
            canvas.drawBitmap(fondo2,0f,0f,paint)
            canvas.drawBitmap(encendido_color,20f,100f,paint)
            canvas.drawBitmap(encendido_color,360f,100f,paint)
            canvas.drawBitmap(encendido_color,700f,100f,paint)
        }

        //Fantasma
        fantasma.pintar(canvas,paint)
    }
    // Re-pintar fantasma
    fun repintar(){
        fantasma.coordRandom()
    }
}