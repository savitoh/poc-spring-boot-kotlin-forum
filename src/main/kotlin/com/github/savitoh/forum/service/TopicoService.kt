package com.github.savitoh.forum.service

import com.github.savitoh.forum.modelo.Curso
import com.github.savitoh.forum.modelo.Topico
import com.github.savitoh.forum.modelo.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {

    private val topico = Topico(
        id = 1,
        titulo = "Como tornar código Kotlin mais indiomático?",
        mensagem = "Procuro dicas para tornar código escrito em Kotlin mais indiomático.",
        curso = Curso(
            id = 1,
            nome = "Primeiros passos com Kotlin",
            categoria = "Programação"
        ),
        autor = Usuario(
            id = 1L,
            nome = "Sávio Raires",
            email = "savio@email.com"
        )
    )

    fun getTopicos() : List<Topico> = listOf(topico)
}