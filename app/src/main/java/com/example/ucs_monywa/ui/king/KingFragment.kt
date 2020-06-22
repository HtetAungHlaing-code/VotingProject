package com.example.ucs_monywa.ui.king

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
import com.example.ucs_monywa.ui.model.KingItem

class KingFragment : Fragment(),KingAdapter.KingClickListener {

    private lateinit var kingAdapter: KingAdapter
    private lateinit var kingViewModel: KingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_king, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kingAdapter = KingAdapter()

        King_Recycler.apply{
            adapter = KingAdapter
            layoutmanager = LinearLayoutManager(context)
        }
        observedView()

        kingAdapter.setClick(this)

    }

    fun observedView(){
        kingViewModel = ViewModelProvider(this).get(KingViewModel::class.java)
        kingViewModel
    }

    override fun onResume() {
        super.onResume()
        kingViewModel
    }

    override fun onclick(kingItem: KingItem) {

    }
}