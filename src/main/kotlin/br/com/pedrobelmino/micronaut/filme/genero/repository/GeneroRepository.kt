package br.com.pedrobelmino.micronaut.filme.genero.repository

import br.com.pedrobelmino.micronaut.filme.genero.domain.Genero
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@JdbcRepository(dialect = Dialect.MYSQL)
interface GeneroRepository : PageableRepository<Genero?, Long?> {

    fun save(@NonNull name: @NotBlank String?): Genero?

    fun update(@NonNull @Id id: @NotNull Long?, @NonNull name: @NotBlank String?): Long
}