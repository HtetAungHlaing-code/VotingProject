package com.example.ucs_monywa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ucs_monywa.ui.model.KingItem
import com.example.ucs_monywa.ui.model.Queen
import com.example.ucs_monywa.ui.model.QueenItem
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
        }

        override fun onClick(v: View?) {
            clickListener.onclick(queenItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view = LayoutInflater.from(parent.context).inflate()
        return view
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