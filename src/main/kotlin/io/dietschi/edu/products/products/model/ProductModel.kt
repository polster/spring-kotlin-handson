package io.dietschi.edu.products.products.model

import java.util.*

class ProductModel(
    val id: UUID? = null,
    val name: String,
    private val attributes: MutableMap<String, String>
) {

    fun addAttribute(name: String,
                     value: String) {

        attributes[name] = value
    }

    fun removeAttribute(name: String) = attributes.remove(name)

    fun getAttributes(): Map<String, String> = attributes.toMap()
}