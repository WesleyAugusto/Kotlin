package br.com.curso.model

import io.micronaut.data.annotation.GeneratedValue
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class Cliente(

    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val documento: String,
    val endereco: String
)
