package br.com.pedrobelmino.micronaut.filme.genero.domain

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import javax.validation.constraints.NotNull


@MappedEntity
data class Genero(@field:Id
                  @GeneratedValue(GeneratedValue.Type.AUTO)
                  val id: Long?,
                  var name: @NotNull String?) {
}