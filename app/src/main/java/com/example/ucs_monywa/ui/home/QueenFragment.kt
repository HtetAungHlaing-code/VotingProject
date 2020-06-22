package com.example.ucs_monywa.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ucs_monywa.R
import com.example.ucs_monywa.adapter.KingAdapter
import com.example.ucs_monywa.adapter.QueenAdapter

class QueenFragment : Fragment() {

    private lateinit var queenViewModel: QueenViewModel
    private lateinit var queenAdapter: QueenAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queenAdapter = QueenAdapter()
        Queen_Recyclergit.apply{
            adapter = KingAdapter
            layoutmanager = LinearLayoutManager(context)
        }

        obseredView()
    }
    fun obseredView(){
        queenViewModel = ViewModelProvider(this).get(QueenViewModel::class.java)
        queenViewModel
    }

    override fun onResume() {
        super.onResume()
        queenViewModel
    }
}