package com.kuhyunjin.mypocketnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.crossfade
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder

private val imageRequestHeaders = NetworkHeaders.Builder()
    .set("User-Agent", "MyPocketNews/1.0 (https://github.com/ku-hyunjin)")
    .build()

class NewsAdapter(
    private val articles: List<Article>,
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.newsImageView)
        private val sourceTextView: TextView = itemView.findViewById(R.id.newsSourceTextView)
        private val titleTextView: TextView = itemView.findViewById(R.id.newsTitleTextView)
        private val descriptionTextView: TextView =
            itemView.findViewById(R.id.newsDescriptionTextView)

        fun bind(article: Article) {
            imageView.contentDescription = article.title
            imageView.load(article.imageUrl.ifBlank { null }) {
                httpHeaders(imageRequestHeaders)
                placeholder(R.drawable.ic_news_image_placeholder)
                error(R.drawable.ic_news_image_placeholder)
                fallback(R.drawable.ic_news_image_placeholder)
                crossfade(true)
            }
            sourceTextView.text = article.source
            titleTextView.text = article.title
            descriptionTextView.text = article.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size
}
