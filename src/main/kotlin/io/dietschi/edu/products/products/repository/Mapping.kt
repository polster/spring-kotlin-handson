package io.dietschi.edu.products.products.repository

import io.dietschi.edu.products.products.model.ProductModel

fun ProductModel.toDocument() = ProductDocument(
    productModel = this
)