package com.github.savitoh.forum.controller

import com.github.savitoh.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun getTopicos() = topicoService.getTopicos()

}