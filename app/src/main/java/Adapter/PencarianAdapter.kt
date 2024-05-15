package Adapter

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import api.DataItem
import com.bumptech.glide.Glide
import com.example.renshumobile.R

data class PencarianAdapter(private val Datalist: List<DataItem>): RecyclerView.Adapter<PencarianAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.gridlay,parent,false)
        return DataViewHolder(view)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val curre = Datalist[position]
        holder.habatxt.text = curre.price.toString()
        holder.nabatxt.text = curre.name

        Glide.with(holder.itemView.context).load(curre.image).into(holder.imgba)

    }

    override fun getItemCount(): Int {
        return Datalist.count()
    }
    class DataViewHolder(item:View): RecyclerView.ViewHolder(item){
        val nabatxt:TextView = item.findViewById(R.id.nabatext)
        val habatxt:TextView = item.findViewById(R.id.habatext)
        val imgba:ImageView = item.findViewById(R.id.imgbarang)

    }
}