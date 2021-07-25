package com.github.savitoh.forum.mapper

import com.github.savitoh.forum.dto.response.TopicoResponse
import com.github.savitoh.forum.modelo.Topico
import org.springframework.stereotype.Component
import java.time.ZoneOffset

@Component
class TopicoResponseMapper : Mapper<Topico, TopicoResponse> {

    override fun map(t: Topico): TopicoResponse {
        return TopicoResponse(
            titulo = t.titulo,
            mensagem = t.mensagem,
            criacaoEmEpochMilliSegundos = t.criacao.toInstant(ZoneOffset.UTC).toEpochMilli(),
            status = t.status,
            nomeAutor = t.autor.nome,
        )
    }
}