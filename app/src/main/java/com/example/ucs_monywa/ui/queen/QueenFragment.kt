package com.example.ucs_monywa.ui.queen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ucs_monywa.R

class QueenFragment : Fragment() {

    private lateinit var homeViewModel: QueenViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD:app/src/main/java/com/example/ucs_monywa/ui/queen/QueenFragment.kt
        val root = inflater.inflate(R.layout.fragment_home, container, false)
=======
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_queen, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
>>>>>>> origin/Heinnanda:app/src/main/java/com/example/ucs_monywa/ui/home/HomeFragment.kt
        return root
    }
}