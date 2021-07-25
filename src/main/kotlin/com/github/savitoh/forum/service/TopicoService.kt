package com.github.savitoh.forum.service

import com.github.savitoh.forum.modelo.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(cursoService: CursoService, usuarioService: UsuarioService) {

    private companion object {
        var topicos = mutableListOf<Topico>()
            private set
    }

    init {
        val cursos = cursoService.listar()
        val usuarios = usuarioService.listar()
        val topico = Topico(
            id = 1,
            titulo = "Como tornar código Kotlin mais indiomático?",
            mensagem = "Procuro dicas para tornar código escrito em Kotlin mais indiomático.",
            curso = cursos[0],
            autor = usuarios[0]
        )
        val topico2 = Topico(
            id = 2,
            titulo = "Alternativas ao Optinal com Kotlin",
            mensagem = "Quais approaches podemos usar no kotlin em substituição ao Optional?",
            curso = cursos[0],
            autor = usuarios[1]
        )
        val topico3 = Topico(
            id = 3,
            titulo = "Como criar uma Monad em Kotlin?",
            mensagem = "Procuro exemplos de código usando recurso de Monads em Kotlin.",
            curso = cursos[0],
            autor = usuarios[2]
        )
        topicos = mutableListOf(topico, topico2, topico3)
    }

    fun listar(): List<Topico> = topicos.toList()

    fun criarTopico(topico: Topico) = topicos.add(topico)

    fun buscarPorId(id: Long): Topico? = topicos.find { it.id == id }
}