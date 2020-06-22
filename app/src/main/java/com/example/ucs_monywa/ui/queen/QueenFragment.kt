package com.example.ucs_monywa.ui.queen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ucs_monywa.R
import com.example.ucs_monywa.adapter.QueenAdapter
import kotlinx.android.synthetic.main.fragment_queen.*


class QueenFragment : Fragment() {

    private lateinit var queenViewModel: QueenViewModel
    private lateinit var queenAdapter: QueenAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_queen, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        queenAdapter = QueenAdapter()
        Queen_Recycler.apply{
            adapter = queenAdapter
            layoutManager = LinearLayoutManager(context)
        }

        obseredView()
    }
    fun obseredView(){
        queenViewModel = ViewModelProvider(this).get(QueenViewModel::class.java)
        queenViewModel.getQueen().observe(viewLifecycleOwner,
        Observer {
            queenAdapter.update(it)
        })
    }

    override fun onResume() {
        super.onResume()
        queenViewModel.loadQueen()
    }

}