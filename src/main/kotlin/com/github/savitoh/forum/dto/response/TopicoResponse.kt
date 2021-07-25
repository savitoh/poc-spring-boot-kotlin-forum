package com.github.savitoh.forum.dto.response

import com.github.savitoh.forum.modelo.StatusTopico

data class TopicoResponse(
    val titulo: String,
    val mensagem: String,
    val criacaoEmEpochMilliSegundos: Long,
    val status: StatusTopico,
    val nomeAutor: String,
)
