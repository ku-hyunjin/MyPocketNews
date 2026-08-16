package com.kuhyunjin.mypocketnews

data class Article(
    val title: String,
    val description: String,
    val imageUrl: String,
    val source: String,
    val articleUrl: String,
)

object SampleNewsData {
    val articles = listOf(
        Article(
            title = "Technology brings new changes to everyday life",
            description = "New technology is helping people work and communicate more easily.",
            imageUrl = "https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=1200&q=80",
            source = "Global News",
            articleUrl = "https://example.com/news/technology",
        ),
        Article(
            title = "Cities create more green spaces for residents",
            description = "Local communities are opening new parks to provide comfortable places to relax.",
            imageUrl = "https://images.unsplash.com/photo-1449824913935-59a10b8d2000?auto=format&fit=crop&w=1200&q=80",
            source = "Daily World",
            articleUrl = "https://example.com/news/green-city",
        ),
        Article(
            title = "People discover new ways to enjoy culture",
            description = "Museums and galleries are offering more ways to experience art from around the world.",
            imageUrl = "",
            source = "Culture Today",
            articleUrl = "https://example.com/news/culture",
        ),
    )
}
