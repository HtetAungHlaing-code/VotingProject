package com.example.ucs_monywa.ui.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ucs_monywa.R
import com.example.ucs_monywa.ui.api.VoteApiInterface
import com.example.ucs_monywa.ui.king.KingViewModel
import com.example.ucs_monywa.ui.model.KingVote
import com.example.ucs_monywa.ui.model.QueenVote
import com.example.ucs_monywa.ui.queen.QueenViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailsFragment : Fragment() {
    val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"

    private lateinit var kingViewModel: KingViewModel
    private lateinit var queenViewModel: QueenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        var data= arguments.let { DetailsFragmentArgs.fromBundle(it!!) }
        var kingId = data?.VoteID
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService = retrofit.create(VoteApiInterface::class.java)
        btn_vote.setOnClickListener {
            val code = txt_code.text.toString()
            var apiCall = retrofitService.voteKing(code,kingId)
            var apiCallQ = retrofitService.voteQueen(code,kingId)
            if (kingId=="K1" && kingId=="K2" && kingId=="K3" && kingId=="K4" &&kingId=="K5" &&kingId=="K6" && kingId=="K7" &&kingId=="K8" &&kingId=="K9" &&kingId=="K10" ){
                apiCall.enqueue(object : Callback<KingVote>{
                    override fun onFailure(call: Call<KingVote>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<KingVote>, response: Response<KingVote>) {
                        Toast.makeText(
                            context,
                            response.body().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                })
            }else{

                apiCallQ.enqueue(object :Callback<QueenVote>{
                    override fun onFailure(call: Call<QueenVote>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<QueenVote>, response: Response<QueenVote>) {
                        Toast.makeText(
                            context,
                            response.body().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                })
            }



        }
    }

    fun observeViewModel(){

        var data= arguments.let { DetailsFragmentArgs.fromBundle(it!!) }
        Log.d("data>>","$data")
        txt_name.text = data.Name
        txt_class.text = data.Class
        Picasso.get().load(data.Image).placeholder(R.drawable.ic_launcher_background).into(imageDetail)
        txt_vote.text = "Vote: " + data.VoteCount
        //var dataQ =arguments?.let{DetailsFragmentArgs.fromBundle(it)}

    }
}
