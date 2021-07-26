package com.github.savitoh.forum.service

import com.github.savitoh.forum.dto.request.AtualizacaoTopicoRequest
import com.github.savitoh.forum.dto.request.NovoTopicoRequest
import com.github.savitoh.forum.modelo.AtualizacaoRecursoResultado
import com.github.savitoh.forum.modelo.CriacaoRecursoResultado
import com.github.savitoh.forum.modelo.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private val cursoService: CursoService, private val usuarioService: UsuarioService) {

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

    fun criar(novoTopico: NovoTopicoRequest): CriacaoRecursoResultado<Topico> {
        val curso = cursoService.listar()
            .find { it.id == novoTopico.idCurso }
            ?: return CriacaoRecursoResultado.Failure(message = "Curso não encontrado com ID: ${novoTopico.idCurso}",
                cause = NoSuchElementException())
        val autor = usuarioService.listar()
            .find { it.id == novoTopico.idAutor }
            ?: return CriacaoRecursoResultado.Failure(message = "Autor não encontrado com ID: ${novoTopico.idAutor}",
                cause = NoSuchElementException())
        val topico = Topico(
            id = topicos.size.toLong() + 1,
            titulo = novoTopico.titulo,
            mensagem = novoTopico.mensagem,
            curso = curso,
            autor = autor
        )
        topicos.add(topico)
        return CriacaoRecursoResultado.Success(value = topico)
    }

    fun atualizar(id: Long, atualizacaoTopicoRequest: AtualizacaoTopicoRequest): AtualizacaoRecursoResultado<Topico> {
        return this.buscarPorId(id)?.let { topico ->
            topico.titulo = atualizacaoTopicoRequest.titulo
            topico.mensagem = atualizacaoTopicoRequest.mensagem
            AtualizacaoRecursoResultado.Success
        } ?: AtualizacaoRecursoResultado.Failure(message = "Tópico não encontrado com ID: $id",
            cause = NoSuchElementException())
    }

    fun excluir(id: Long) = buscarPorId(id)?.let { topicos.remove(it) } ?: false

    fun buscarPorId(id: Long): Topico? = topicos.find { it.id == id }
}