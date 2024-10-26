package com.example.klinikapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.klinikapp.DetailDoctors
import com.example.klinikapp.Model.ModelListDoctors
import com.example.klinikapp.R

class ListDoctorsAdapter(
    private val itemDoctorsList: List<ModelListDoctors>,
    private val context: Context // Pass the context to the adapter
) : RecyclerView.Adapter<ListDoctorsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemDoctors: ImageView = itemView.findViewById(R.id.imgItemDoctor)
        var txtNamaDoctors: TextView = itemView.findViewById(R.id.txtNamaDoctor)
        var txtSpesDoctors: TextView = itemView.findViewById(R.id.txtSpesDoctor)
        var txtReviewDoctors: TextView = itemView.findViewById(R.id.txtReviewDoctor)
        var txtJumlahRating: TextView = itemView.findViewById(R.id.txtJumlahRating)
        val cardDoctor: CardView = itemView.findViewById(R.id.cardDoctor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_doctors,
            parent, false
        )
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorsList[position]
        holder.txtNamaDoctors.text = currentItem.NamaDoctor
        holder.txtSpesDoctors.text = currentItem.SpesDoctor
        holder.txtReviewDoctors.text = currentItem.JumlahReview
        holder.txtJumlahRating.text = currentItem.JumlahRating
        holder.imgItemDoctors.setImageResource(currentItem.ImgDoctor)

        holder.cardDoctor.setOnClickListener {
            // Create intent to navigate to DetailDoctors
            val intent = Intent(context, DetailDoctors::class.java).apply {
                putExtra("Image Doctor", currentItem.ImgDoctor)
                putExtra("Nama Doctor", currentItem.NamaDoctor)
                putExtra("Spes Doctor", currentItem.SpesDoctor)
                putExtra("Jumlah Review", currentItem.JumlahReview)
                putExtra("Jumlah Rating", currentItem.JumlahRating)
                putExtra("Date", currentItem.date)
                putExtra("Time", currentItem.time)
                putExtra("loc",currentItem.loc)
                putExtra("loc1",currentItem.loc1)
                putExtra("family",currentItem.family)

            }

            // Start DetailDoctors activity
            context.startActivity(intent)

            // Show a Toast message
            Toast.makeText(context, currentItem.NamaDoctor, Toast.LENGTH_SHORT).show()
        }
    }
}
