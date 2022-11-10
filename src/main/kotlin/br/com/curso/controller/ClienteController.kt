package br.com.curso.controller

import br.com.curso.model.Cliente
import br.com.curso.service.ClienteService
import io.micronaut.http.annotation.*

@Controller("/clientes")
open class ClienteController(private val clienteService: ClienteService) {
    @Post
    fun create(@Body cliente: Cliente) {
        clienteService.create(cliente)
    }

    @Get
    fun findAll(): List<Cliente> {
        return clienteService.findAll()
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): Cliente {
        return clienteService.findById(id)
    }

    @Delete("/{id}")
    fun deleteId(@PathVariable id: Long) {
        clienteService.deleteId(id)
    }

    @Put("/{id}")
    open fun update(@PathVariable id: Long, @Body cliente: Cliente) {
        clienteService.update(id, cliente)
    }
}