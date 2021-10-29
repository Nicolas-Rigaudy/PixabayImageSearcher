package org.libreapps.imagesearcher.model

data class Data(
    val total: Int,
    val totalHits: Int,
    val images: List<Image>
)