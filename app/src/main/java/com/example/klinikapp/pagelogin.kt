package com.example.klinikapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.klinikapp.screen.HomeDoctorsActivity


class pagelogin : AppCompatActivity() {

    private lateinit var txtget1: TextView
    private lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pagelogin)

        txtget1 = findViewById(R.id.txtget1)
        btnlogin = findViewById(R.id.btnlogin)

        txtget1.setOnClickListener {
            val intent = Intent(this, PageRegister::class.java)
            startActivity(intent)

            btnlogin.setOnClickListener {
                val intent = Intent(this, HomeDoctorsActivity::class.java)
                startActivity(intent)

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }
            }
        }
    }
}