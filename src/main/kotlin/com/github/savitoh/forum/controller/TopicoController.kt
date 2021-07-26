package com.github.savitoh.forum.controller

import com.github.savitoh.forum.dto.request.AtualizacaoTopicoRequest
import com.github.savitoh.forum.dto.request.NovoTopicoRequest
import com.github.savitoh.forum.dto.response.TopicoResponse
import com.github.savitoh.forum.dto.response.error.ErrorResponse
import com.github.savitoh.forum.mapper.Mapper
import com.github.savitoh.forum.modelo.AtualizacaoRecursoResultado
import com.github.savitoh.forum.modelo.CriacaoRecursoResultado
import com.github.savitoh.forum.modelo.Topico
import com.github.savitoh.forum.service.TopicoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("v1/topicos")
class TopicoController(
    private val topicoService: TopicoService,
    private val topicoResponseMapper: Mapper<Topico, TopicoResponse>,
) {

    @GetMapping
    fun listar(): List<TopicoResponse> = topicoService.listar().map { topico -> topicoResponseMapper.map(topico) }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable("id") identificador: Long): ResponseEntity<TopicoResponse> {
        return topicoService.buscarPorId(identificador).let { topico: Topico? ->
            if (topico == null) ResponseEntity.notFound().build()
            else ResponseEntity.ok(topicoResponseMapper.map(topico))
        }
    }

    @PostMapping
    fun criar(
        @RequestBody @Valid novoTopicoRequest: NovoTopicoRequest,
        uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<ErrorResponse> {
        return when (val result = topicoService.criar(novoTopicoRequest)) {
            is CriacaoRecursoResultado.Success -> {
                val uriComponents = uriComponentsBuilder.path("/{id}").buildAndExpand(result.value.id)
                ResponseEntity.created(uriComponents.toUri()).build()
            }
            is CriacaoRecursoResultado.Failure -> ResponseEntity.badRequest().body(ErrorResponse(result.message))
        }
    }

    @PatchMapping("/{id}")
    fun atualizar(
        @PathVariable("id") id: Long,
        @RequestBody @Valid atualizacaoTopicoRequest: AtualizacaoTopicoRequest,
    ): ResponseEntity<ErrorResponse> {
        return when (val result = topicoService.atualizar(id, atualizacaoTopicoRequest)) {
            is AtualizacaoRecursoResultado.Success -> ResponseEntity.noContent().build()
            is AtualizacaoRecursoResultado.Failure -> ResponseEntity.badRequest().body(ErrorResponse(result.message))
        }
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long): ResponseEntity<Nothing> {
        return if (topicoService.excluir(id)) ResponseEntity.ok().build()
        else ResponseEntity.notFound().build()
    }
}