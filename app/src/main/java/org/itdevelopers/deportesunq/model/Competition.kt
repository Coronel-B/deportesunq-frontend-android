package org.itdevelopers.deportesunq.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName;

data class Competition(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("name") @Expose private val name: Int,
    @SerializedName("year") @Expose private val year: String,
    @SerializedName("champion") @Expose private val champion: String,
    @SerializedName("competition_detail") @Expose private val competitionDetail: List<CompetitionDetail>? = null)

data class CompetitionDetail(
    @SerializedName("position") @Expose private val position: Int,
    @SerializedName("team") @Expose private val team: Team)

data class Team(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("alias") @Expose private val alias: String,
    @SerializedName("fullName") @Expose private val fullName: String)