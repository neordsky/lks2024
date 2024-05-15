package com.example.renshumobile

import Fragment.DialogFrag
import Model.Model_User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import api.DataItem
import api.ResponsejsonItem
import com.bumptech.glide.Glide
class BarangAdapter(private val context: Context,private val listData: ArrayList<DataItem>): RecyclerView.Adapter<BarangAdapter.DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.gridlay,parent,false)
        return  DataViewHolder(view)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val curren = listData[position]
        holder.txtnaba.text = curren.name
        holder.txthaba.text = curren.price.toString()
        val cont = holder.itemView.context
        Glide.with(cont).load(curren.image).into(holder.imgba)


        holder.itemView.setOnClickListener {

            Toast.makeText(holder.itemView.context,"I click ${curren.name}",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

   inner class DataViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val txtnaba : TextView = item.findViewById(R.id.nabatext!!)
        val txthaba: TextView = item.findViewById(R.id.habatext)
        val imgba: ImageView = item.findViewById(R.id.imgbarang)

        init {
            item.setOnClickListener {
                val fm = (context as AppCompatActivity).supportFragmentManager
                DialogFrag().show(fm,"MyDia")
            }
        }
    }
}