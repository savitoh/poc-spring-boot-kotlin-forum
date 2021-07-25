package com.github.savitoh.forum.modelo

sealed class CriacaoRecursoResultado<out T : Any> {
    data class Success<out T : Any>(val value: T) : CriacaoRecursoResultado<T>()
    data class Failure(val message: String, val cause: Exception? = null) : CriacaoRecursoResultado<Nothing>()
}
