package org.itdevelopers.deportesunq.interfaces

import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.Competitions
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {

    @GET("/api/competitions")
    fun getCompetitionList(): Call<Competitions>

    @GET("/api/competition/{competition}")
    fun getCompetition(@Path("competition_id") id: Int): Call<Competition>

}