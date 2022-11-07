package br.com.curso.model

import io.micronaut.core.annotation.Introspected

import io.micronaut.data.annotation.MappedEntity
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
@Introspected
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    val name: String,
    val documento: String,
    val endereco: String
)
