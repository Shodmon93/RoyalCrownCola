package com.example.royalcrowncola

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RCItemViewHolder>() {

    var onItemClick: ((RcCola) -> Unit)? = null
    private var item: List<RcCola> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RCItemViewHolder {
        return RCItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_rc_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RCItemViewHolder, position: Int) {
        when (holder) {
            else -> {
                holder.bind(item[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setData(rcCola: ArrayList<RcCola>) {
        val data = DataModel.setData()
        item = data
    }

    inner class RCItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_tittle)
        val description: TextView = view.findViewById(R.id.title_desc)
        val image: ImageView = view.findViewById(R.id.item_image)

        init {
            onItemClick?.invoke(item[absoluteAdapterPosition])
        }

        fun bind(cola: RcCola) {
            title.text = cola.tittle
            description.text = cola.description
            image.setImageResource(cola.image)

        }
    }
}