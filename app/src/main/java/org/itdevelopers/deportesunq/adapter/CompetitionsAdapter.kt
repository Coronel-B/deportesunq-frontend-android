package org.itdevelopers.deportesunq.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import org.itdevelopers.deportesunq.ui.competitions.CompetitionsViewModel

class CompetitionsAdapter(@LayoutRes layoutId: Int, viewModel: CompetitionsViewModel)
    : RecyclerView.Adapter<CompetitionsAdapter.GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class GenericViewHolder(binding: ViewDataBinding, itemView: View):
        RecyclerView.ViewHolder(itemView) {

        fun bind(viewModel: CompetitionsViewModel, position: Int) {
//            TODO:
        }


    }


}