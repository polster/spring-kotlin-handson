package io.dietschi.edu.products.products.web.exception

data class ErrorResponse(
    val status: Int? = null,
    val message: String? = null
) {
    val timestamp: Long = System.currentTimeMillis()
}