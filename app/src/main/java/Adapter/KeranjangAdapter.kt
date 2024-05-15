package Adapter

import Model.ModelBarang
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.RecyclerView
import api.DataItem
import api.ResponsejsonItem
import com.bumptech.glide.Glide

class KeranjangAdapter(private val listda: ArrayList<DataItem>) : RecyclerView.Adapter<KeranjangAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(com.example.renshumobile.R.layout.kercard,parent,false  )
        return DataViewHolder(view)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currenc = listda[position]
        val quan = 1
        holder.txtnaba.text = currenc.name
        holder.txthaba.text = currenc.price.toString()
        holder.txtquan.text = quan.toString()

        Glide.with(holder.itemView.context).load(currenc.image).into(holder.imgb)
//         holder.adbut.setOnClickListener {
//             currenc.quanty?.plus(1)
//         }
//        holder.revbut.setOnClickListener {
//            currenc.quanty?.minus(1)
//        }
         holder.adbut.setOnClickListener {
              currenc.id!! + 1
             notifyItemChanged(position)
         }

        holder.delit.setOnClickListener {
            if (currenc.id!! < 0){

            }
            else{
                currenc.id!! - 1
            }

        }



    }

    override fun getItemCount(): Int {
        return listda.count()
    }
    class DataViewHolder(item:View) : RecyclerView.ViewHolder(item){
        val txtnaba : TextView = item.findViewById(com.example.renshumobile.R.id.nabatext)
        val txthaba : TextView = item.findViewById(com.example.renshumobile.R.id.habatext)
        val txtquan : TextView= item.findViewById(com.example.renshumobile.R.id.quantext)
        val imgb: ImageView= item.findViewById(com.example.renshumobile.R.id.imgkerbar)
        val adbut : Button = item.findViewById(com.example.renshumobile.R.id.addbut)
        val revbut: Button = item.findViewById(com.example.renshumobile.R.id.removbut)
        val delit:Button = item.findViewById(com.example.renshumobile.R.id.delitem)


    }
}