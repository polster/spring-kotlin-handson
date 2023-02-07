package io.dietschi.edu.products.products.repository

import io.dietschi.edu.products.products.model.ProductModel
import org.springframework.stereotype.Repository
import java.util.UUID
import kotlin.jvm.optionals.getOrElse

@Repository
class ProductRepository(
    val productRepositoryMongo: ProductRepositoryMongo
) {

    fun findById(id: UUID): ProductModel {
        return productRepositoryMongo
            .findById(id)
            .getOrElse { throw NoSuchElementException("Resource not found!") }
            .productModel
    }

    fun persist(productModel: ProductModel): UUID {

        val stored = productRepositoryMongo.save(
            productModel.toDocument()
        )
        return stored.id
    }

    fun findAll(): List<ProductModel> =
        productRepositoryMongo
            .findAll()
            .map { it.productModel }
}