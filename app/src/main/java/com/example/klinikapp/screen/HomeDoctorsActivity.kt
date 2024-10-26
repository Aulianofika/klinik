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
            ModelListDoctors(R.drawable.dokter1, "Dr. Werish", "Dentist", "(110 Reviews)", "5.0", "28 october, 2023", "16.00","6743 Rachview","Dr.Werish","Jane Copper"),
            ModelListDoctors(R.drawable.dokter2, "Dr. Wolr", "Dentist", "(120 Reviews)", "5.0", "28 March, 2023", "16.00","5432 Rachview","Dr.Wolr","Jane run"),
            ModelListDoctors(R.drawable.dokter3, "Dr. Zaki", "Dentist", "(130 Reviews)", "5.0", "28 october, 2023", "16.00","755 Rachview","Dr.Zaki","Wtyi Copper"),
            ModelListDoctors(R.drawable.dokter4, "Dr. Kyle", "Obgyn", "(180 Reviews)", "5.0", "28 March, 2023", "16.00","977 Rachview","Dr.Kyle","  Rwuyi Copper"),
            ModelListDoctors(R.drawable.dokter5, "Dr. Zaqty", "Dentist", "(150 Reviews)", "5.0", "28 october, 2023", "16.00","122 Rachview","Dr.Zaqty","JaKyne Copper"),
            ModelListDoctors(R.drawable.dokter6, "Dr. Brian", "Obgyn", "(130 Reviews)", "5.0", "28 March, 2023", "16.00","366 Rachview","Dr.Brian","Jane Copper"),
            ModelListDoctors(R.drawable.dokter1, "Dr. Kytpy", "Obgyn", "(160 Reviews)", "5.0", "28 october, 2023", "16.00","345 Rachview","Dr.Kypty","Jane Copper"),
        )

        doctorList.addAll(doctors)
        homeDoctorsAdapter.notifyDataSetChanged()
    }
}
