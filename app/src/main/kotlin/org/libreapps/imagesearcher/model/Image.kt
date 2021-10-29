package org.libreapps.imagesearcher.model

import android.os.Parcelable

data class Image(
    val id: Int,
    val pageUrl: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageUrl: String,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user_id: String,
    val user: String,
    val userImageUrl: String
)