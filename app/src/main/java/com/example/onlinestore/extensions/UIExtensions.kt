package com.example.onlinestore.extensions

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.onlinestore.R
import com.example.onlinestore.utils.OnSingleClickListener

fun Fragment.showToastShort(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun View.setOnSingleClickListener(l: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener(l))
}

fun ImageView.loadImagesWithGlide(url: String, loader: ProgressBar) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .listener(object : RequestListener<Drawable?> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable?>,
                isFirstResource: Boolean
            ): Boolean {
                loader.visibility = View.VISIBLE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable?>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                loader.visibility = View.GONE
                return false
            }
        })
        .into(this)
}

fun Fragment.setDropMenu(): ArrayAdapter<String> = object : ArrayAdapter<String>(
    requireActivity(),
    R.layout.item_drop_down,
    resources.getStringArray(R.array.filters)
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        parent.overScrollMode = View.OVER_SCROLL_NEVER
        return super.getView(position, convertView, parent)
    }
}