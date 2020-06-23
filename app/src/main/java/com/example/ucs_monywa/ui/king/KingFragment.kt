package com.example.ucs_monywa.ui.king

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ucs_monywa.R
import com.example.ucs_monywa.adapter.KingAdapter
import com.example.ucs_monywa.ui.model.KingItem
import kotlinx.android.synthetic.main.fragment_king.*

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
            adapter = kingAdapter
            layoutManager = LinearLayoutManager(context)
        }
        observedViewModel()

        kingAdapter.setClick(this)

    }

    fun observedViewModel(){
        kingViewModel = ViewModelProvider(this).get(KingViewModel::class.java)
        kingViewModel.getKing().observe(viewLifecycleOwner,
        Observer {
            kingAdapter.update(it)
        })
    }

    override fun onResume() {
        super.onResume()
        kingViewModel.loadKing()
    }

    override fun onclick(kingItem: KingItem) {
        var action = KingFragmentDirections.actionNavGalleryToDetailsFragment(kingItem.vote_count.toString(),kingItem.`class`,kingItem.name,kingItem.img_url,kingItem.id)
        findNavController().navigate(action)
    }
}