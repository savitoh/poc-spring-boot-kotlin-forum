package com.github.savitoh.forum.modelo

sealed class AtualizacaoRecursoResultado<out T : Any> {
    object Success : AtualizacaoRecursoResultado<Nothing>()
    data class Failure(val message: String, val cause: Exception? = null) : AtualizacaoRecursoResultado<Nothing>()
}
