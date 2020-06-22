package com.example.ucs_monywa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ucs_monywa.ui.model.KingItem

class KingAdapter(var kingList: List<KingItem> = ArrayList()) : RecyclerView.Adapter<KingAdapter.KingViewHolder>(){

    var clickListener : KingClickListener? = null

    fun setClick(clickListener: KingClickListener){
        this.clickListener = clickListener
    }

    inner class KingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
        private lateinit var kingItem : KingItem
        init {
            itemView.setOnClickListener(this)
        }

        fun bindKing(kingItem : KingItem){
            this.kingItem = kingItem

        }

        override fun onClick(v: View?) {
            clickListener?.onclick(kingItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
        var view = LayoutInflater.from(parent.context).inflate()
        return view
    }

    override fun getItemCount(): Int {
        return kingList.size
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
        holder.bindKing(kingList[position])
    }

    fun update(kingItemList: List<KingItem>){
        this.kingList = kingItemList
        notifyDataSetChanged()
    }

    interface KingClickListener{
        fun onclick(kingItem: KingItem)
    }
}