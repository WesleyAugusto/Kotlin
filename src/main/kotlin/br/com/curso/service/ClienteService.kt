package br.com.curso.service

import br.com.curso.exception.RegistroNaoEncontradoException
import br.com.curso.model.Cliente
import br.com.curso.repository.ClienteRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(private val clienteRepository: ClienteRepository) {

    fun create(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun findAll(pageable: Pageable): Page<Cliente> {
        return clienteRepository.findAll(pageable)
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id).orElseThrow { RegistroNaoEncontradoException("registro nao encontrado") }
    }

    fun deleteId(id: Long) {
        findById(id)
        clienteRepository.deleteById(id)
    }

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val clienteDb: Cliente = findById(id)
        clienteDb.name = cliente.name
        clienteDb.documento = cliente.documento
        clienteDb.endereco = cliente.endereco
        clienteRepository.save(clienteDb)
    }
}
