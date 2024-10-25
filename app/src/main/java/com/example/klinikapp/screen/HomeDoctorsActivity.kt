package com.example.klinikapp.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klinikapp.Model.ModelListDoctors
import com.example.klinikapp.R
import com.example.klinikapp.adapter.ListDoctorsAdapter

class HomeDoctorsActivity : AppCompatActivity() {

    private lateinit var rvListDoctors: RecyclerView
    private lateinit var homeDoctorsAdapter: ListDoctorsAdapter

    // Array data doctors
    private val doctorList = mutableListOf<ModelListDoctors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctors)

        rvListDoctors = findViewById(R.id.rv_list_doctors)
        homeDoctorsAdapter = ListDoctorsAdapter(doctorList, this)

        rvListDoctors.apply {
            layoutManager = GridLayoutManager(this@HomeDoctorsActivity, 1)
            adapter = homeDoctorsAdapter
        }

        // Create dummy data
        prepareDataDoctors()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareDataDoctors() {
        val doctors = listOf(
            ModelListDoctors(R.drawable.dokter1, "Dr. Werish", "Dentist", "170", "5.0", "26 oktober, 2024", "16.00",),
            ModelListDoctors(R.drawable.dokter2, "Dr. Wolr", "Dentist", "120", "5.0", " 26 oktober, 2024", "16.00"),
            ModelListDoctors(R.drawable.dokter3, "Dr. Zaki", "Dentist", "120", "5.0", "26 oktober, 2024", "16.00"),
            ModelListDoctors(R.drawable.dokter4, "Dr. Kyle", "Obgyn", "100", "5.0", "26 oktober, 2024", "16.00"),
            ModelListDoctors(R.drawable.dokter5, "Dr. Zaki", "Dentist", "180", "5.0", "26 oktober, 2024", "16.00"),
            ModelListDoctors(R.drawable.dokter6, "Dr. Kyle", "Obgyn", "130", "5.0", "26 oktober, 2024", "16.00"),
            ModelListDoctors(R.drawable.dokter1, "Dr. Kyle", "Obgyn", "100", "5.0", "26 oktober, 2024", "16.00"),
        )

        doctorList.addAll(doctors)
        homeDoctorsAdapter.notifyDataSetChanged()
    }
}
