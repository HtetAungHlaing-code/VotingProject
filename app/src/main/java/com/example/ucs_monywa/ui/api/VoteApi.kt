package com.example.ucs_monywa.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VoteApi {
    companion object{
        const val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    }
    private val voteapiInterface: VoteApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        voteapiInterface = retrofit.create(VoteApiInterface::class.java)
    }
    fun getKing() = voteapiInterface.getKing()
    fun getQueen() = voteapiInterface.getQueen()
}