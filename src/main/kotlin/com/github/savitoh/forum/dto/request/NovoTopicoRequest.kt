package com.github.savitoh.forum.dto.request

data class NovoTopicoRequest(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long,
)
