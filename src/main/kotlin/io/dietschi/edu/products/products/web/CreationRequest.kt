package io.dietschi.edu.products.products.web

import io.dietschi.edu.products.products.model.ProductType

data class CreationRequest(
    val model: String?,
    val name: String,
    val productType: ProductType?,
    val attributes: Map<String, String>
)