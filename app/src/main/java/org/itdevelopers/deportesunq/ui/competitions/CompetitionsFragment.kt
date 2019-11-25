package org.itdevelopers.deportesunq.ui.competitions

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import org.itdevelopers.deportesunq.R
import org.itdevelopers.deportesunq.model.Competition

class CompetitionsFragment : Fragment() {

    companion object {
        fun newInstance() =
            CompetitionsFragment()
    }

    private lateinit var viewModel: CompetitionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.competitions_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CompetitionsViewModel::class.java)
        // TODO: Use the ViewModel


    }

    private fun setupBinding(savedInstanceState: Bundle?) {

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
