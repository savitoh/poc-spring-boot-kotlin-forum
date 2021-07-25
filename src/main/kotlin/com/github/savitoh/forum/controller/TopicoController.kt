package com.github.savitoh.forum.controller

import com.github.savitoh.forum.dto.request.NovoTopicoRequest
import com.github.savitoh.forum.dto.response.TopicoResponse
import com.github.savitoh.forum.mapper.Mapper
import com.github.savitoh.forum.modelo.Topico
import com.github.savitoh.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun criar(@RequestBody novoTopicoRequest: NovoTopicoRequest): ResponseEntity<Unit> {
        topicoService.criar(novoTopicoRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }
}