package com.example.ucs_monywa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ucs_monywa.R
import com.example.ucs_monywa.ui.model.KingItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.king_item.view.*

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
            itemView.txt_KingName.text = kingItem.name

            Picasso.get().load(kingItem.img_url).placeholder(R.drawable.ic_launcher_background).into(itemView.txt_KingImage)

        }

        override fun onClick(v: View?) {
            clickListener?.onclick(kingItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.king_item,parent,false)
        return KingViewHolder(view)
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