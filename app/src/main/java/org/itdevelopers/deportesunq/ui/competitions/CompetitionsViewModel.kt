package org.itdevelopers.deportesunq.ui.competitions

import android.view.View
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.itdevelopers.deportesunq.R
import org.itdevelopers.deportesunq.adapter.CompetitionsAdapter
import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.CompetitionDetailItem
import org.itdevelopers.deportesunq.model.Competitions

class CompetitionsViewModel(private var competitions: Competitions,
                            private var competitionsAdapter: CompetitionsAdapter,
                            var selected: MutableLiveData<Competition>,
                            var competitionDetailItems: ObservableArrayMap<Int, CompetitionDetailItem>,
                            var loading: ObservableInt,
                            var showEmpty: ObservableInt): ViewModel() {

    init {
        competitions = Competitions()
        competitionsAdapter = CompetitionsAdapter(R.layout.view_competition, this)
        selected = MutableLiveData()
        competitionDetailItems = ObservableArrayMap()
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





}
