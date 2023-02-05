package io.dietschi.edu.products.products.model

import java.util.UUID

class ProductModel(
    val id: UUID,
    val name: String,
    private val attributes: MutableMap<String, String>
) {

    fun addAttribute(name: String,
                     value: String) {

        attributes[name] = value
    }

    fun removeAttribute(name: String) = attributes.remove(name)
}