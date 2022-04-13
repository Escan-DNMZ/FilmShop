package com.escan.filmproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RvAdapter(private val filmList:List<Filmler>,private val context:Context): RecyclerView.Adapter<RvAdapter.RowHolder>() {
    inner class RowHolder(view:View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false)
        return RowHolder(itemView)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.itemView.textViewFilmBaslik.text = filmList[position].filmName
        holder.itemView.textViewFilmFiyat.text = "${filmList[position].filmPrice} TL"
        holder.itemView.imageView.setImageResource(context.resources.getIdentifier(filmList[position].filmImage,"drawable",context.packageName))

        holder.itemView.buttonSepeteEkle.setOnClickListener {
            holder.itemView.buttonSepeteEkle.setText("Sepete Eklendi")
            Toast.makeText(context, "${filmList[position].filmName} sepete eklendi.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
}