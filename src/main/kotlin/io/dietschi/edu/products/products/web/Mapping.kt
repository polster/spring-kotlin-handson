package io.dietschi.edu.products.products.web

import io.dietschi.edu.products.products.model.ProductModel

fun CreationRequest.toModel() = ProductModel(
    model = this.model,
    name = this.name,
    attributes = this.attributes.toMutableMap()
)