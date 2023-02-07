package io.dietschi.edu.products.products.service

import io.dietschi.edu.products.products.model.ProductModel
import io.dietschi.edu.products.products.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getById(id: UUID): ProductModel =
        productRepository.findById(id)

    fun createNew(productModel: ProductModel): UUID =
        productRepository.persist(productModel)

    fun updateAttributes(id: UUID, attributes: Map<String, String>): ProductModel {

        val productModel = productRepository.findById(id)
        attributes.forEach {
            productModel.setAttribute(it.key, it.value)
        }
        productRepository.persist(productModel)

        return productModel
    }

    fun query(attributes: Map<String, String>): List<ProductModel> {

        // never do this in production code, just a bad example...
        return productRepository
            .findAll()
            .filter { filterByAttributes(attributes, it.getAttributes()) }
            .sortedBy { it.name }
            .take(10)
    }

    private fun filterByAttributes(givenAttributes: Map<String, String>,
                                   productAttributes: Map<String, String>): Boolean {

        var match = false
        givenAttributes.forEach { entry ->
            match = when (entry.value) {
                productAttributes[entry.key] -> true
                else -> false
            }
        }

        return match
    }
}