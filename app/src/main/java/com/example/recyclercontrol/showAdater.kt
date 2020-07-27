package com.example.recyclercontrol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.show_adapter.view.*

class showAdater:RecyclerView.Adapter<showAdater.VH>() {
    private var data = arrayListOf<dataclass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.show_adapter,parent,false)
        return VH(view)

    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position])
    }

    fun update (list: ArrayList<dataclass>){
        this.data=list
        notifyDataSetChanged()
    }

    fun remove (poz:Int){
        if (poz > -1 && data.size > poz){
            data.removeAt(poz)
            notifyDataSetChanged()
        }
    }

    fun add(item: dataclass){
        data.add(item)
       notifyItemInserted(1)
    }




    class VH(view:View):RecyclerView.ViewHolder(view){
        fun bind (item:dataclass){
            itemView.text1.text=item.tvtext1
            itemView.text2.text=item.tvtext2
        }
    }


}