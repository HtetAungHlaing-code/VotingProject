package com.example.ucs_monywa.ui.queen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ucs_monywa.R
import com.example.ucs_monywa.adapter.QueenAdapter
import com.example.ucs_monywa.ui.king.KingFragmentDirections
import com.example.ucs_monywa.ui.model.QueenItem
import kotlinx.android.synthetic.main.fragment_queen.*


class QueenFragment : Fragment(),QueenAdapter.QueenClickListener {

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
        queenAdapter.setClick(this)
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

    override fun onclick(queenItem: QueenItem) {
        var action = QueenFragmentDirections.actionNavHomeToDetailsFragment(queenItem.vote_count.toString(),queenItem.`class`,queenItem.name,queenItem.img_url,queenItem.id)
        findNavController().navigate(action)
    }


}