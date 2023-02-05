package io.dietschi.edu.products.products.web

data class CreationRequest(
    val model: String?,
    val name: String,
    val attributes: Map<String, String>
)