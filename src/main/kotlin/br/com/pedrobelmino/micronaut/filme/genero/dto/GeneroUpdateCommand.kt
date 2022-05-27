package br.com.pedrobelmino.micronaut.filme.genero.dto

import io.micronaut.core.annotation.Introspected

@Introspected
class GeneroUpdateCommand(val id: Long?, val name: String?)