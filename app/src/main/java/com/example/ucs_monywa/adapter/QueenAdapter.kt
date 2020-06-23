package com.example.ucs_monywa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ucs_monywa.R
import com.example.ucs_monywa.ui.model.KingItem
import com.example.ucs_monywa.ui.model.Queen
import com.example.ucs_monywa.ui.model.QueenItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.king_item.view.*
import kotlinx.android.synthetic.main.item_queen.view.*
import kotlinx.coroutines.channels.ticker

class QueenAdapter(var queenList: List<QueenItem> = ArrayList()) : RecyclerView.Adapter<QueenAdapter.QueenViewHolder>(){

    var clickListener: QueenClickListener? = null

    fun setClick(clickListener: QueenClickListener){
        this.clickListener = clickListener
    }

    inner class QueenViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview),View.OnClickListener{
        private lateinit var queenItem: QueenItem
        init {
            itemview.setOnClickListener(this)
        }
        fun bindQueen(queenItem: QueenItem){
            this.queenItem = queenItem
            itemView.txt_QueenName.text = queenItem.name

            Picasso.get().load(queenItem.img_url).placeholder(R.drawable.ic_launcher_background).into(itemView.txt_QueenImage)

        }

        override fun onClick(v: View?) {
            clickListener?.onclick(queenItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_queen,parent,false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return queenList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.bindQueen(queenList[position])
    }

    fun update(queenItemList : List<QueenItem>){
        this.queenList = queenItemList
    }
    interface QueenClickListener{
        fun onclick(queenItem: QueenItem)
    }
}