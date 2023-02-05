package io.dietschi.edu.products.products.web

import io.dietschi.edu.products.products.model.ProductModel
import io.dietschi.edu.products.products.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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
    fun product(@PathVariable("id") id: UUID): ResponseEntity<ProductModel> {

        val product = productService.getById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping
    fun createNew(@RequestBody creationRequest: CreationRequest): ResponseEntity<CreationResponse> {

        val id = productService.createNew(
            creationRequest.toModel()
        )
        return ResponseEntity.ok(
            CreationResponse(id)
        )
    }
}