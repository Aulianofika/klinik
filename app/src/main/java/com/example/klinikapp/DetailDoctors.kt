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
    private lateinit var txtDetailloc: TextView
    private lateinit var txtDetailloc1: TextView
    private lateinit var txtDetailfamily: TextView

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
        txtDetailTime = findViewById(R.id.txtTime)
        txtDetaiDate = findViewById(R.id.txtDate)
        txtDetailloc = findViewById(R.id.txtloc)
        txtDetailloc1 = findViewById(R.id.txtloc1)
        txtDetailfamily = findViewById(R.id.txtfamily)

        //get data
        val imgDoctor = intent.getIntExtra("Image Doctor", 0)
        val namaDoctor = intent.getStringExtra("Nama Doctor")
        val spesDoctor = intent.getStringExtra("Spes Doctor")
        val jumlahReview = intent.getStringExtra("Jumlah Review")
        val jumlahRating = intent.getStringExtra("Jumlah Rating")
        val date = intent.getStringExtra("Date")
        val time = intent.getStringExtra("Time")
        val loc = intent.getStringExtra("loc")
        val loc1 = intent.getStringExtra("loc1"
        )
        val family = intent.getStringExtra("family")

        //set data ke widget
        imageDetailDoctor.setImageResource(imgDoctor)
        txtDetailNamaDoctor.setText(namaDoctor)
        txtDetailSpesDoctor.setText(spesDoctor)
        txtDetailJumlahReview.setText(jumlahReview)
        txtDetailJumlahRating.setText(jumlahRating)
        txtDetailTime.setText(time)
        txtDetaiDate.setText(date)
        txtDetailloc.setText(loc)
        txtDetailloc1.setText(loc1)
        txtDetailfamily.setText(family)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}