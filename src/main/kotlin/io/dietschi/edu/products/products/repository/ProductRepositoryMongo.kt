package io.dietschi.edu.products.products.repository

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ProductRepositoryMongo : MongoRepository<ProductDocument, UUID>