package org.itdevelopers.deportesunq.ui.competitions

import android.view.View
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import org.itdevelopers.deportesunq.R
import org.itdevelopers.deportesunq.adapter.CompetitionsAdapter
import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.CompetitionDetailItem
import org.itdevelopers.deportesunq.model.Competitions
import androidx.lifecycle.MutableLiveData as MutableLiveData

/**
 * OBS: La variable selected tiene que ser privada sino tira un error de "same JVM signature"
 * Source: https://stackoverflow.com/a/44719646/5279996
 */
class CompetitionsViewModel(private var competitions: Competitions,
                            private var competitionsAdapter: CompetitionsAdapter,
                            private var selected: MutableLiveData<Competition>? = null,
                            var competitionDetail: ObservableArrayMap<Int, List<CompetitionDetailItem>>,
                            var loading: ObservableInt,
                            var showEmpty: ObservableInt): ViewModel() {

    init {
        competitions = Competitions()
        competitionsAdapter = CompetitionsAdapter(R.layout.view_competition, this)
        selected = MutableLiveData()
        competitionDetail = ObservableArrayMap()
        loading = ObservableInt(View.GONE)
        showEmpty = ObservableInt(View.GONE)
    }

    fun fetchList() {
        competitions.fetchList()
    }

    fun getCompetitions(): MutableLiveData<List<Competition>> {
        return competitions.getCompetitions()
    }

    fun getAdapter(): CompetitionsAdapter {
        return competitionsAdapter
    }

    fun setCompetitionsInAdapter(competitions: List<Competition>) {
        competitionsAdapter.setCompetitions(competitions)
        competitionsAdapter.notifyDataSetChanged()
    }

    fun getSelected(): MutableLiveData<Competition>? {
        return this.selected
    }

    fun onItemClick(index: Int) {
        val competition: Competition? = getCompetitionAt(index)
        selected?.value = competition
    }

    private fun getCompetitionAt(index: Int?): Competition? {
        if (competitions.getCompetitions().value != null && index != null &&
                competitions.getCompetitions().value!!.size > index) {
            return competitions.getCompetitions().value!![index]
        }
        return null
    }

    fun fetchCompetitionDetailAt(index: Int) {
        val competition: Competition? = getCompetitionAt(index)
        if (competition != null && !competitionDetail. ) {
            competition.fetchCompetitionDetail()
        }
    }





}
