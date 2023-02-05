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
        productRepository.add(productModel)
}