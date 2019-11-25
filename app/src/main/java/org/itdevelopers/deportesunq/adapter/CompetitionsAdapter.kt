package org.itdevelopers.deportesunq.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import org.itdevelopers.deportesunq.BR
import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.ui.competitions.CompetitionsViewModel

class CompetitionsAdapter(
    @LayoutRes private val layoutId: Int,
    private val viewModel: CompetitionsViewModel
) : RecyclerView.Adapter<CompetitionsAdapter.GenericViewHolder>() {

    private var competitions: List<Competition>? = null

    private fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }

    override fun getItemCount(): Int {
        return if (competitions == null) {
            0
        } else {
            competitions!!.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun setCompetitions(competitions: List<Competition>) {
        this.competitions = competitions
    }

    class GenericViewHolder internal constructor(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        internal fun bind(viewModel: CompetitionsViewModel, position: Int?) {
            binding.setVariable(BR.viewModel, viewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }

    }


}