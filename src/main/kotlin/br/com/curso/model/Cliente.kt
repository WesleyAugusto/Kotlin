package br.com.curso.model

import io.micronaut.core.annotation.Introspected
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
    var nome: String,
    var documento: String,
    var endereco: String
)