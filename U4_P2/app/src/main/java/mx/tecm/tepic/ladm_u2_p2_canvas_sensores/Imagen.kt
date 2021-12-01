package mx.tecm.tepic.ladm_u2_p2_canvas_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import java.util.*

class Imagen (punteroLienzo: Focos, posX:Float, posY:Float, nombreImagen:Int) {
    var puntero = punteroLienzo
    var x = posX
    var y = posY
    var imagen = BitmapFactory.decodeResource(punteroLienzo.resources, nombreImagen)

    fun pintar(c: Canvas, p: Paint){
        c.drawBitmap(imagen, x, y, p)
    }// Pintar

    fun coordRandom(){
        var pantalla = Random()

        //Dimenciones de aparicion en pantalla
        this.x = pantalla.nextInt(700-20).toFloat()
        this.y = pantalla.nextInt(1400-20).toFloat()
    }// coordenadas Random de aparicion
}