package com.github.savitoh.forum.modelo

import java.time.LocalDateTime

data class Respostas(
    val id: Long? = null,
    val mensagem: String,
    val criacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val ehSolucao: Boolean = false,
)
