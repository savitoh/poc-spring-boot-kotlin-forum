package com.github.savitoh.forum.service

import com.github.savitoh.forum.modelo.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    private companion object {
        var data = mutableListOf<Usuario>()
            private set
    }

    init {
        val usuario1 = Usuario(
            id = 1L,
            nome = "Sávio Raires",
            email = "savio@email.com"
        )
        val usuario2 = Usuario(
            id = 2L,
            nome = "Leticia",
            email = "leticia@email.com"
        )
        val usuario3 = Usuario(
            id = 3L,
            nome = "João",
            email = "joao@email.com"
        )
        data = mutableListOf(usuario1, usuario2, usuario3)
    }

    fun listar(): List<Usuario> = data.toList()

}