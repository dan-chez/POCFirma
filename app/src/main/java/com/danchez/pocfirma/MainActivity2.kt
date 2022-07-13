package com.danchez.pocfirma

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val image = findViewById<ImageView>(R.id.ivFirma)
        val bytes = intent.getStringExtra("data")
        val imgUri: Uri = Uri.parse(bytes)
        image.setImageURI(null)
        //image.setImageURI(imgUri)

    }
}