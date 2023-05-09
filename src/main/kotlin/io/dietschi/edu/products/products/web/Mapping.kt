package io.dietschi.edu.products.products.web

import io.dietschi.edu.products.products.model.ProductModel
import io.dietschi.edu.products.products.model.ProductType

fun CreationRequest.toModel() = ProductModel(
    model = this.model,
    name = this.name,
    productType = this.productType ?: ProductType.Product,
    attributes = this.attributes.toMutableMap()
)