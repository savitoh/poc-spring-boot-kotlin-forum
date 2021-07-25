package com.github.savitoh.forum.service

import com.github.savitoh.forum.modelo.Curso
import com.github.savitoh.forum.modelo.Topico
import com.github.savitoh.forum.modelo.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val cursoProgramacao = Curso(
            id = 1,
            nome = "Primeiros passos com Kotlin",
            categoria = "Programação"
        )
        val topico = Topico(
            id = 1,
            titulo = "Como tornar código Kotlin mais indiomático?",
            mensagem = "Procuro dicas para tornar código escrito em Kotlin mais indiomático.",
            curso = cursoProgramacao,
            autor = Usuario(
                id = 1L,
                nome = "Sávio Raires",
                email = "savio@email.com"
            )
        )
        val topico2 = Topico(
            id = 2,
            titulo = "Alternativas ao Optinal com Kotlin",
            mensagem = "Quais approaches podemos usar no kotlin em substituição ao Optional?",
            curso = cursoProgramacao,
            autor = Usuario(
                id = 3L,
                nome = "Leticia",
                email = "leticia@email.com"
            )
        )
        val topico3 = Topico(
            id = 3,
            titulo = "Como criar uma Monad em Kotlin?",
            mensagem = "Procuro exemplos de código usando recurso de Monads em Kotlin.",
            curso = cursoProgramacao,
            autor = Usuario(
                id = 3L,
                nome = "João",
                email = "joao@email.com"
            )
        )
        topicos = listOf(topico, topico2, topico3)
    }

    fun listar(): List<Topico> = topicos
}