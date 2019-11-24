package org.itdevelopers.deportesunq.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.itdevelopers.deportesunq.R

class CompetitionsBindings {

    @BindingAdapter("setAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    @BindingAdapter("logoUrl")
    fun bindRecyclerViewAdapter(imageView: ImageView, logoUrl: String) {
//            If we don't do this, you'll see the old image appear briefly before it's replaced with the current image
        if (imageView.getTag(R.id.logo_url) != logoUrl
        ) {
            imageView.setImageBitmap(null)
            imageView.setTag(R.id.logo_url, logoUrl)
            Glide.with(imageView).load(logoUrl).into(imageView)
        }
    }

}