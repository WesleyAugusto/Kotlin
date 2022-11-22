package br.com.curso.repository

import br.com.curso.model.Cliente
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
abstract class ClienteRepository(private val entityManager:EntityManager):JpaRepository<Cliente, Long> {
    abstract fun findByNome(nome:String,pageable: Pageable): Page<Cliente>

    @Query("select c from Cliente c")
    abstract fun listar():List<Cliente>
@Transactional
    fun listarComImplementacao():List<Cliente>{
        var queryString = "select c from Cliente c"
        var query = entityManager.createQuery(queryString)
        var clientes = query.resultList
        return clientes as List<Cliente>
    }
}