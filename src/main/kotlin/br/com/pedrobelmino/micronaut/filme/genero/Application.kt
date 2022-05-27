package br.com.pedrobelmino.micronaut.filme.genero

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.pedrobelmino.micronaut.filme.genero")
		.start()

	// 6204ms jvm
}

