package com.example.ucs_monywa.ui.api

import com.example.ucs_monywa.ui.model.King
import com.example.ucs_monywa.ui.model.Queen
import retrofit2.Call
import retrofit2.http.GET

interface VoteApiInterface {
    @GET("king")
    fun getKing(): Call<King>

    @GET("queen")
    fun getQueen(): Call<Queen>
}