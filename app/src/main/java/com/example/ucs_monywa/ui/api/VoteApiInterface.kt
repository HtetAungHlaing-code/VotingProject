package com.example.ucs_monywa.ui.api

import com.example.ucs_monywa.ui.model.King
import com.example.ucs_monywa.ui.model.KingVote
import com.example.ucs_monywa.ui.model.Queen
import com.example.ucs_monywa.ui.model.QueenVote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface VoteApiInterface {
    @GET("king")
    fun getKing(): Call<King>

    @GET("queen")
    fun getQueen(): Call<Queen>

    @POST("kingvote")
    fun voteKing(
        @Query("code") code: String,
        @Query("king_id") kingId: String
    ): Call<KingVote>

    @POST("queenvote")
    fun voteQueen(
        @Query("code") code:String,
        @Query("queen_id") queenId:String
    ):Call<QueenVote>

}