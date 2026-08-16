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
            imageUrl = "https://example.com/images/technology.jpg",
            source = "Global News",
            articleUrl = "https://example.com/news/technology",
        ),
        Article(
            title = "Cities create more green spaces for residents",
            description = "Local communities are opening new parks to provide comfortable places to relax.",
            imageUrl = "https://example.com/images/green-city.jpg",
            source = "Daily World",
            articleUrl = "https://example.com/news/green-city",
        ),
        Article(
            title = "People discover new ways to enjoy culture",
            description = "Museums and galleries are offering more ways to experience art from around the world.",
            imageUrl = "https://example.com/images/culture.jpg",
            source = "Culture Today",
            articleUrl = "https://example.com/news/culture",
        ),
    )
}
