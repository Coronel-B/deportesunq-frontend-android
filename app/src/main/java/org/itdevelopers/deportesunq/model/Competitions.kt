package org.itdevelopers.deportesunq.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName;

data class Competitions(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("name") @Expose private val name: Int,
    @SerializedName("year") @Expose private val year: String,
    @SerializedName("champion_team") @Expose private val championTeam: String,
    @SerializedName("competition_details") @Expose private val competitionDetails: List<CompetitionDetail>? = null)

data class CompetitionDetail(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("competition_detail_items") @Expose private val competitionDetailItems: List<CompetitionDetailItem>) {
}

data class CompetitionDetailItem(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("position") @Expose private val position: Int,
    @SerializedName("team") @Expose private val team: Team
)

data class Team(
    @SerializedName("id") @Expose private val id: Int,
    @SerializedName("alias") @Expose private val alias: String,
    @SerializedName("fullName") @Expose private val fullName: String)