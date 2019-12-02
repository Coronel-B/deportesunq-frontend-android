package org.itdevelopers.deportesunq.model

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.itdevelopers.deportesunq.services.CompetitionsApiService
import org.itdevelopers.deportesunq.net.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Competitions : BaseObservable() {

    private lateinit var status: String

//    https://stackoverflow.com/a/50893555/5279996
    private var competitionsList: MutableList<Competition> = ArrayList()

    private val competitionsLiveData: MutableLiveData<List<Competition>> = MutableLiveData()

    fun setStatus(status: String) {
        this.status = status
    }

    fun addCompetition(competition: Competition) {
        competitionsList.add(competition)
    }

    fun getCompetitions(): MutableLiveData<List<Competition>> {
        return competitionsLiveData
    }

    /**
     * Source: https://stackoverflow.com/a/43737962/5279996
     */
    fun fetchCompetitionsList() {
        val callback: Callback<Competitions> = object : Callback<Competitions> {
            override fun onResponse(call: Call<Competitions>, response: Response<Competitions>) {
                val body: Competitions? = response.body()
                if (body != null) {
                    status = body.status
                }
                competitionsLiveData.value = body?.competitionsList
            }

            override fun onFailure(call: Call<Competitions>, t: Throwable) {
                Log.d("Test", t.message, t)
            }
        }

        API.client.create(CompetitionsApiService::class.java).getCompetitions().enqueue(callback)
    }

}

data class Competition(
    @SerializedName("id") @Expose private val competitionId: Int = -1,
    @SerializedName("name") @Expose private val name: String = "",
    @SerializedName("year") @Expose private val year: Int = -1,
    @SerializedName("champion") @Expose private val championTeam: String = "",
    @SerializedName("logo_url") @Expose private val logoUrl: String = "",
    private val competitionDetailLiveData: MutableLiveData<CompetitionDetail> = MutableLiveData(),
    private var competitionDetail: CompetitionDetail? = null) : //TODO: Evaluar si deberia ser de tipo Mutable
    BaseObservable() {

    private lateinit var status: String

    fun setStatus(status: String) {
        this.status = status
    }

    fun getName(): String {
        return "$name "
    }

    fun getYear(): Int {
        return year
    }

    fun getChampionTeam(): String {
        return championTeam
    }

    fun getLogoUrl(): String {
        return logoUrl
    }

    fun loadCompetitionDetail(competitionDetail: CompetitionDetail) {
        this.competitionDetail = competitionDetail
    }

    fun getCompetitionDetail(): MutableLiveData<CompetitionDetail> {
        return competitionDetailLiveData
    }

    fun fetchCompetitionDetail(callback: Callback<CompetitionDetail>) {
        API.client.create(CompetitionsApiService::class.java).getCompetitionDetail(competitionId).enqueue(callback)
    }

}

data class CompetitionDetail(
    private val competitionDetailItems: List<CompetitionDetailItem>?)

data class CompetitionDetailItem(
    @SerializedName("position") @Expose private val position: Int,
    @SerializedName("team") @Expose private val team: Team)

data class Team(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("alias") @Expose private val alias: String,
    @SerializedName("fullName") @Expose private val fullName: String)

