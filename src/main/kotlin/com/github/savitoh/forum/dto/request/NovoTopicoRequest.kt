package com.github.savitoh.forum.dto.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoRequest(
    @field:NotEmpty
    @field:Size(min = 5, max = 200)
    val titulo: String,
    @field:NotEmpty
    @field:Size(min = 10, max = 2064)
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long,
)
