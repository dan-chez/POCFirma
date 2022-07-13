package com.danchez.pocfirma

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.github.gcacace.signaturepad.views.SignaturePad
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var linear: LinearLayout
    lateinit var pad: SignaturePad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pad = findViewById(R.id.signaturePad)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        linear = findViewById(R.id.linear)
        image = findViewById(R.id.image)
        saveButton.isEnabled = false
        clearButton.isEnabled = false
        clearButton.setOnClickListener {
            pad.clear()
        }
        saveButton.setOnClickListener {
            image.visibility = View.VISIBLE
            linear.visibility = View.GONE
            pad.visibility = View.GONE
            image.setImageBitmap(pad.signatureBitmap)
        }
        pad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {

            }

            override fun onSigned() {
                saveButton.isEnabled = true
                clearButton.isEnabled = true
            }

            override fun onClear() {
                saveButton.isEnabled = false
                clearButton.isEnabled = false
            }
        })
    }

    override fun onBackPressed() {
        if (image.visibility == View.VISIBLE) {
            image.visibility = View.GONE
            linear.visibility = View.VISIBLE
            pad.visibility = View.VISIBLE
            pad.clear()
        } else {
            super.onBackPressed()
        }
    }
}