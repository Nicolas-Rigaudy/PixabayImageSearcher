package org.libreapps.imagesearcher.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.libreapps.imagesearcher.R
import org.libreapps.imagesearcher.model.Image

class ImagesAdapter(private val data: List<Image>) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    class ImageViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bind(image: Image){
            val imageView = view.findViewById<ImageView>(R.id.imageView)

            Glide.with(view.context).load(image.webformatURL).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.image_card_view, parent, false)
        return ImageViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }
}