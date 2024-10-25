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

class PageRegister : AppCompatActivity() {
    private lateinit var txtget2: TextView
    private lateinit var btnlogin2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_register)

        txtget2 = findViewById(R.id.txtget2)
        btnlogin2 = findViewById(R.id.btnlogin2)

        txtget2.setOnClickListener {
            val intent = Intent(this, pagelogin::class.java)
            startActivity(intent)

            btnlogin2.setOnClickListener {
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