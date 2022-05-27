package br.com.pedrobelmino.micronaut.filme.genero.controller

import br.com.pedrobelmino.micronaut.filme.genero.domain.Genero
import br.com.pedrobelmino.micronaut.filme.genero.repository.GeneroRepository
import br.com.pedrobelmino.micronaut.filme.genero.dto.GeneroUpdateCommand
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpHeaders
import io.micronaut.http.annotation.*
import java.net.URI
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Controller("/genres")
class GeneroController(protected val generoRepository: GeneroRepository) {

    @Post
    fun salvar(@Body("name") name: @NotBlank String?): HttpResponse<Genero?> {
        val genre = generoRepository.save(name)
        return HttpResponse
            .created(genre)
            .headers{ headers: MutableHttpHeaders -> headers.location(location(genre!!.id)) }
    }

    @Get("/list")
    fun listar(pageable: @Valid Pageable?): List<Genero?> {
        return generoRepository.findAll(pageable).content
    }

    @Get("/count")
    fun contar(): Long = generoRepository.count()

    @Put
    fun atualizar(@Body command: @Valid GeneroUpdateCommand?): HttpResponse<*> {
        generoRepository.update(command!!.id, command.name)
        return HttpResponse
            .noContent<Any>()
            .header(HttpHeaders.LOCATION, location(command.id).path)
    }

    protected fun location(id: Long?): URI {
        return URI.create("/genres/$id")
    }

}