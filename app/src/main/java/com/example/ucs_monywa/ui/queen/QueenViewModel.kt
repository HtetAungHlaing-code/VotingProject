package com.example.ucs_monywa.ui.queen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ucs_monywa.ui.api.VoteApi
import com.example.ucs_monywa.ui.model.King
import com.example.ucs_monywa.ui.model.KingItem
import com.example.ucs_monywa.ui.model.Queen
import com.example.ucs_monywa.ui.model.QueenItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QueenViewModel : ViewModel() {

    var QueenResults: MutableLiveData<List<QueenItem>> = MutableLiveData()
    var resultLoadError: MutableLiveData<Boolean> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getQueen(): LiveData<List<QueenItem>> = QueenResults
    fun getError(): LiveData<Boolean> = resultLoadError
    fun gerLoading(): LiveData<Boolean> = loading

    private val voteApi: VoteApi = VoteApi()

    fun loadQueen(){
        loading.value=true
        val apiCall = voteApi.getQueen()
        apiCall.enqueue(object : Callback<Queen> {
            override fun onFailure(call: Call<Queen>, t: Throwable) {
                Log.i("Error","Load Fail Queen")
                resultLoadError.value= true
                loading.value=false
            }

            override fun onResponse(call: Call<Queen>, response: Response<Queen>) {
                Log.i("Success","Load Success Queen")

                response.isSuccessful.let {
                    loading.value=false
                    val queenResultList:List<QueenItem> = response.body()?: emptyList()
                    QueenResults.value = queenResultList
                }


            }})
    }

    fun loadQueenDetail(id: String){
        loading.value= true
        val apiCall = voteApi.getQueen()
        apiCall.enqueue(object : Callback<Queen>{
            override fun onFailure(call: Call<Queen>, t: Throwable) {
                resultLoadError.value= true
                loading.value = false
            }

            override fun onResponse(call: Call<Queen>, response: Response<Queen>) {
                response.isSuccessful.let {
                    loading.value= false
                    val QueenDetailResult:List<QueenItem> = response.body()?: emptyList()
                    QueenResults.value= QueenDetailResult
                }
            }

        })
    }
}
