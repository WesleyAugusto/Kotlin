package br.com.curso.controller

import br.com.curso.model.Cliente
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import repository.ClienteRepository

@Controller("clientes")
class ClienteController (
        private val clienteRepository:ClienteRepository
        ){
    @Post
    fun create(@Body cliente:Cliente){
        clienteRepository.save(cliente)
    }
    @Get
    fun findAll():List<Cliente>{
        return clienteRepository.findAll()
    }
}