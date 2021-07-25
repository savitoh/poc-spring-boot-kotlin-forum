package com.github.savitoh.forum.service

import com.github.savitoh.forum.modelo.Curso
import org.springframework.stereotype.Service

@Service
class CursoService {

    private companion object {
        var data = mutableListOf<Curso>()
            private set
    }

    init {
        val cursoBasicoKotlin = Curso(
            id = 1,
            nome = "Primeiros passos com Kotlin.",
            categoria = "Programação"
        )
        val cursoBasicoDataScience = Curso(
            id = 2,
            nome = "Primeiros passos em Data Science.",
            categoria = "Data Science"
        )
        val cursoIntermediarioDataScience = Curso(
            id = 3,
            nome = "Passos intermediários em Data Science.",
            categoria = "Data Science"
        )
        data = mutableListOf(
            cursoBasicoKotlin,
            cursoBasicoDataScience,
            cursoIntermediarioDataScience
        )
    }

    fun listar(): List<Curso> = data.toList()

}