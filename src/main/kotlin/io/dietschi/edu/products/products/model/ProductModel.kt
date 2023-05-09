package io.dietschi.edu.products.products.model

class ProductModel(
    val model: String?,
    val name: String,
    val productType: ProductType,
    private val attributes: MutableMap<String, String>
) {

    fun setAttribute(name: String,
                     value: String) {

        attributes[name] = value
    }

    fun removeAttribute(name: String) = attributes.remove(name)

    fun getAttributes(): Map<String, String> = attributes.toMap()

}