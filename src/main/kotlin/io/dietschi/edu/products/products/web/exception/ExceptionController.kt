package io.dietschi.edu.products.products.web.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionController {

    @ExceptionHandler
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<ErrorResponse> {

        val response = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }
}