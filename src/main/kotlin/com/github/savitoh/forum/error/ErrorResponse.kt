package com.github.savitoh.forum.error

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class ErrorResponse(
    val mensagem: String?,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    val path: String? = null,
)
