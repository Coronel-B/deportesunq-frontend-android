package org.itdevelopers.deportesunq.interfaces

import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.CompetitionDetail
import org.itdevelopers.deportesunq.model.Competitions
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CompetitionsApiInterface {

    @GET("/competitions")
    fun getCompetitions(): Call<Competitions>

    @GET("/competition/{competition}")
    fun getCompetitionDetail(@Path("competition_id") id: Int): Call<CompetitionDetail>

}