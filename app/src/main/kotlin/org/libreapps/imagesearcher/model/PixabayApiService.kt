package org.libreapps.imagesearcher.model

import org.libreapps.imagesearcher.Config
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApiService {

    @GET("?key=${Config.API_KEY}")
    fun getImages(@Query("q") query: String,
                          @Query("lang") language: String,
                          //@Query("id") id: String,
                          @Query("image_type") imageType: String,
                          @Query("orientation") orientation: String,
                          //@Query("category") category: Int,
                          @Query("min_width") minWidth: Int,
                          @Query("min_height") minHeight: Int,
                          //@Query("colors") colors: String,
                          @Query("editors_choice") editorsChoice: Boolean,
                          @Query("safesearch") safeSearch: Boolean,
                          @Query("order") order: String,
                          @Query("page") page: Int,
                          @Query("per_page") perPage: Int
    ): Response<Data>
}