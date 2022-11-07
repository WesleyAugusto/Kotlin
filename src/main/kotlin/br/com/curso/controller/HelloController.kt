package br.com.curso.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces


@Controller("/Hello")
class HelloController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun olaMundo() = "Ola Mundo"
}