package org.itdevelopers.deportesunq.ui.competitions

import android.util.Log
import android.view.View
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import org.itdevelopers.deportesunq.R
import org.itdevelopers.deportesunq.adapter.CompetitionsAdapter
import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.CompetitionDetail
import org.itdevelopers.deportesunq.model.CompetitionDetailItem
import org.itdevelopers.deportesunq.model.Competitions
import org.itdevelopers.deportesunq.net.CompetitionDetailCallback
import retrofit2.Call
import retrofit2.Response
import androidx.lifecycle.MutableLiveData as MutableLiveData

/**
 * OBS: La variable selected tiene que ser privada sino tira un error de "same JVM signature".
 * Inicializo las variables en null para evitar el error ViewModel has no zero argument constructor
 * Source:
 * . https://stackoverflow.com/a/44719646/5279996
 * . https://stackoverflow.com/q/44194579/5279996
 */
class CompetitionsViewModel(private var competitions: Competitions? = null,
                            private var competitionsAdapter: CompetitionsAdapter? = null,
                            private var selected: MutableLiveData<Competition>? = null,
                            var loading: ObservableInt? = null,
                            var showEmpty: ObservableInt? = null): ViewModel() {

    fun init() {
        competitions = Competitions()
        competitionsAdapter = CompetitionsAdapter(R.layout.view_competition, this)
        selected = MutableLiveData()
        loading = ObservableInt(View.GONE)
        showEmpty = ObservableInt(View.GONE)
    }

    fun fetchList() {
        competitions?.fetchList()
    }

    fun getCompetitions(): MutableLiveData<List<Competition>>? {
        return competitions?.getCompetitions()
    }

    fun getAdapter(): CompetitionsAdapter? {
        return competitionsAdapter
    }

    fun setCompetitionsInAdapter(competitions: List<Competition>) {
        competitionsAdapter?.setCompetitions(competitions)
        competitionsAdapter?.notifyDataSetChanged()
    }

    fun getSelected(): MutableLiveData<Competition>? {
        return this.selected
    }

    fun onItemClick(index: Int) {
        val competition: Competition? = getCompetitionAt(index)
        selected?.value = competition
    }

    fun getCompetitionAt(index: Int?): Competition? {
        if (competitions?.getCompetitions()?.value != null && index != null &&
                competitions?.getCompetitions()!!.value!!.size > index) {
            return competitions?.getCompetitions()!!.value!![index]
        }
        return null
    }



    /**
     * TODO: Esto iria al clickear un item, es decir en el viewModel de CompetitionDetail
     * OBS:
     * El detalle (que tiene la lista de ítems) está contenido de una competición
     */
    /*fun fetchCompetitionDetailAt(index: Int) {
        val competition: Competition? = getCompetitionAt(index)
        if (competition != null && !competitionDetail.containsKey(competition.getCompetitionId()) ) {
            competition.fetchCompetitionDetail(object : CompetitionDetailCallback(competition) {

                override fun onResponse(
                    call: Call<CompetitionDetail>,
                    response: Response<CompetitionDetail>
                ) {
                    val body: CompetitionDetail? = response.body()
                    if (body?.getCompetitionDetailItems()?.isNotEmpty()!!) {
                        val competitionDetailItem: CompetitionDetailItem = body.getCompetitionDetailItems()[0]
                        competitionDetail[competition.getCompetitionId()] = competitionDetailItem
                    }
                }

                override fun onFailure(call: Call<CompetitionDetail>, t: Throwable) {
                    Log.e("Test", t.message, t)
                }

            })
        }
    }*/

}
