package com.example.klinikapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailDoctors : AppCompatActivity() {
    private lateinit var imageDetailDoctor : ImageView
    private lateinit var txtDetailNamaDoctor : TextView
    private lateinit var txtDetailSpesDoctor : TextView
    private lateinit var txtDetailJumlahReview: TextView
    private lateinit var detailRating : RatingBar
    private lateinit var txtDetailJumlahRating: TextView
    private lateinit var txtDetaiDate: TextView
    private lateinit var txtDetailTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctors)

        imageDetailDoctor = findViewById(R.id.imgDoctor)
        txtDetailNamaDoctor = findViewById(R.id.txtNamaDoctor)
        txtDetailSpesDoctor = findViewById(R.id.txtSpesDoctor)
        txtDetailJumlahReview = findViewById(R.id.txtReviewDoctor)
        detailRating = findViewById(R.id.rating)
        txtDetailJumlahRating = findViewById(R.id.txtJumlahRating)
        txtDetailTime = findViewById(R.id.txtDTime)
        txtDetaiDate = findViewById(R.id.txtDDate)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}