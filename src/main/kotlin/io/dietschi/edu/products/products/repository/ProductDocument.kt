package io.dietschi.edu.products.products.repository

import io.dietschi.edu.products.products.model.ProductModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(
    collection = "products"
)
data class ProductDocument(
    @Id
    val id: UUID = UUID.randomUUID(),
    val productModel: ProductModel,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val modifiedDate: LocalDateTime = LocalDateTime.now(),
    val version: String = "v1"
)