package br.com.curso.controller

import br.com.curso.model.Cliente
import br.com.curso.repository.ClienteRepository
import io.micronaut.http.annotation.*
import java.util.UUID
import javax.transaction.Transactional

@Controller("/clientes")
open class ClienteController (
        private val clienteRepository: ClienteRepository
        ){
    @Post
    fun create(@Body cliente:Cliente){
        clienteRepository.save(cliente)
    }
    @Get
    fun findAll():List<Cliente>{
        return clienteRepository.findAll()
    }
    @Get("/{id}")
    fun findById(@PathVariable id:Long): Cliente{
        return clienteRepository.findById(id).get()
    }

    @Delete("/{id}")
    fun deleteId(@PathVariable id:Long){
        clienteRepository.deleteById(id)
    }

    @Put("/{id}")
    @Transactional
   open fun update(@PathVariable id: Long,@Body cliente:Cliente){
        val clienteDb = clienteRepository.findById(id).get()
        clienteDb.name = cliente.name
        clienteDb.documento = cliente.documento
        clienteDb.endereco = cliente.endereco
        clienteRepository.save(clienteDb)
    }
}