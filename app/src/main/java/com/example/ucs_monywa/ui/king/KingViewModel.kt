package com.example.ucs_monywa.ui.king

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ucs_monywa.ui.api.VoteApi
import com.example.ucs_monywa.ui.model.King
import com.example.ucs_monywa.ui.model.KingItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingViewModel : ViewModel() {

    var KingResults: MutableLiveData<List<KingItem>> = MutableLiveData()
    var resultLoadError: MutableLiveData<Boolean> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getKing():LiveData<List<KingItem>> = KingResults
    fun getError(): LiveData<Boolean> = resultLoadError
    fun gerLoading(): LiveData<Boolean> = loading

    private val voteApi: VoteApi = VoteApi()

    fun loadKing(){
        loading.value=true
        val apiCall = voteApi.getKing()
        apiCall.enqueue(object : Callback<King> {
            override fun onFailure(call: Call<King>, t: Throwable) {
                Log.i("Error","Load Fail King")
                resultLoadError.value= true
                loading.value=false
            }

            override fun onResponse(call: Call<King>, response: Response<King>) {
                Log.i("Success","Load Success King")

                response.isSuccessful.let {
                    loading.value=false
                    val kingResultList:List<KingItem> = response.body()?: emptyList()
                    KingResults.value= kingResultList
                }

            }

        })
    }
}