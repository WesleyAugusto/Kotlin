package br.com.curso.service

import br.com.curso.model.Cliente
import br.com.curso.repository.ClienteRepository
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
class ClienteService(private val clienteRepository: ClienteRepository) {

    fun create(cliente: Cliente) {
        clienteRepository.save(cliente)
    }

    fun findAll(): List<Cliente> {
        return clienteRepository.findAll()
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id).get()
    }

    fun deleteId(id: Long) {
        clienteRepository.deleteById(id)
    }

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val clienteDb = clienteRepository.findById(id).get()
        clienteDb.name = cliente.name
        clienteDb.documento = cliente.documento
        clienteDb.endereco = cliente.endereco
        clienteRepository.save(clienteDb)
    }
}