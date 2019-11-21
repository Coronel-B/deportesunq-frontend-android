package org.itdevelopers.deportesunq.net

import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.CompetitionDetail
import org.itdevelopers.deportesunq.model.CompetitionDetailItem
import retrofit2.Callback

abstract class CompetitionDetailCallback(private val competition: Competition):
    Callback<CompetitionDetail> {

    protected fun getCompetition(): Competition {
        return competition
    }
}