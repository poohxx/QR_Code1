package com.poohxx.qr_code

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {
    var im: ImageView? = null
    var bGenerate: Button? = null
    var bScan: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        im = findViewById(R.id.imageView)
        bGenerate = findViewById(R.id.bGenerate)
        bScan = findViewById(R.id.bScan)
        bScan?.setOnClickListener{
            startActivity(Intent(this,ScannerActivity::class.java))
        }
        bGenerate?.setOnClickListener{
            generateQrCode("https://2x2tv.ru/upload/setka-editor/715/715b13cdb9703f04a7838f669b68d22d.jpg")
        }
    }
    private fun generateQrCode(text: String){
        val qrGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT, 500)
        try {
            val bMap = qrGenerator.encodeAsBitmap()
            im?.setImageBitmap(bMap)
        }
        catch (e: WriterException){

        }
    }
}