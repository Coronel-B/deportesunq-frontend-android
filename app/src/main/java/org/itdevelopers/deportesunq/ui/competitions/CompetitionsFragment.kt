package org.itdevelopers.deportesunq.ui.competitions

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.itdevelopers.deportesunq.R
import org.itdevelopers.deportesunq.databinding.CompetitionsFragmentBinding
import org.itdevelopers.deportesunq.model.Competition

class CompetitionsFragment : Fragment() {

    companion object {
        fun newInstance() =
            CompetitionsFragment()
    }

    private lateinit var viewModel: CompetitionsViewModel
    private lateinit var fragmentBinding: CompetitionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.competitions_fragment, container, false)
//        return inflater.inflate(R.layout.competitions_fragment, container, false)
        return fragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupBinding(savedInstanceState)
    }

    private fun setupBinding(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(CompetitionsViewModel::class.java)
        if (savedInstanceState == null) {
            viewModel.init()
        }
        fragmentBinding.model = viewModel
        setupListUpdate()
    }

    private fun setupListUpdate() {
        viewModel.loading?.set(VISIBLE)
        viewModel.fetchList()
        viewModel.getCompetitions()?.observe(this,
            Observer<List<Competition>> {
                viewModel.loading?.set(GONE)
                if (it.isEmpty()) {
                    viewModel.showEmpty?.set(VISIBLE)
                } else {
                    viewModel.showEmpty?.set(GONE)
                    viewModel.setCompetitionsInAdapter(it)
                }
            })
        setupListClick()
    }


    //    https://stackoverflow.com/a/52751475/5279996
    private fun setupListClick() {
        viewModel.getSelected()?.observe(this, Observer<Competition> {
            if (it != null) {
                Toast.makeText(
                    activity,
                    "You selected a " + it.getChampionTeam(),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
    }

}
