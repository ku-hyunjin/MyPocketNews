package com.kuhyunjin.mypocketnews

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("w/api.php")
    suspend fun getCurrentEvents(
        @Query("page") page: String,
        @Query("action") action: String = "parse",
        @Query("prop") properties: String = "wikitext|links",
        @Query("format") format: String = "json",
        @Query("formatversion") formatVersion: Int = 2,
    ): ResponseBody
}
