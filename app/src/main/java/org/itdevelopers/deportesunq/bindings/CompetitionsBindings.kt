package org.itdevelopers.deportesunq.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompetitionsBindings {

    @BindingAdapter("setAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    @BindingAdapter("imageUrl")
    fun bindRecyclerViewAdapter(imageView: ImageView, imageUrl: String) {
        if(imageUrl != null) {
//            If we don't do this, you'll see the old image appear briefly before it's replaced with the current image
            //TODO: Implement
        }
    }

}