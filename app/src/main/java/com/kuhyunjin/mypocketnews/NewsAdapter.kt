package com.kuhyunjin.mypocketnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(
    private val articles: List<Article>,
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sourceTextView: TextView = itemView.findViewById(R.id.newsSourceTextView)
        private val titleTextView: TextView = itemView.findViewById(R.id.newsTitleTextView)
        private val descriptionTextView: TextView =
            itemView.findViewById(R.id.newsDescriptionTextView)

        fun bind(article: Article) {
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
