package io.dietschi.edu.products.products.web

import io.dietschi.edu.products.products.model.ProductModel
import io.dietschi.edu.products.products.service.ProductService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController(private var productService: ProductService) {

    @GetMapping("/{id}")
    fun queryById(@PathVariable("id") id: UUID): ResponseEntity<ProductModel> {

        logger.debug("GET: Query product with id $id")

        val product = productService.getById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping
    fun createNew(@RequestBody creationRequest: CreationRequest): ResponseEntity<CreationResponse> {

        logger.debug("POST: Create new resource")

        val id = productService.createNew(
            creationRequest.toModel()
        )
        return ResponseEntity.ok(
            CreationResponse(id)
        )
    }

    @PatchMapping("/{id}/attributes")
    fun updateAttributes(@PathVariable("id") id: UUID,
                         @RequestBody attributes: Map<String, String>): ResponseEntity<ProductModel> {

        logger.debug("PATCH: Update ${attributes.size} attributes for product with id $id")

        val product = productService.updateAttributes(
            id,
            attributes
        )
        return ResponseEntity.ok(product)
    }

    @PostMapping("/search")
    fun queryByAttributes(@RequestBody attributes: Map<String, String>): ResponseEntity<List<ProductModel>> {

        logger.debug("POST: Query by attributes")

        val result = productService.query(attributes)
        return ResponseEntity.ok(result)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ProductController::class.java)
    }
}