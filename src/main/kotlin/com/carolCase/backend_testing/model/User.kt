package com.carolCase.backend_testing.model

import jakarta.persistence.*

@Entity
@Table(name = "users") // user tabellen ger error, så använder @Table för at byta namn på tabellen
data class User(
    val userName: String = "",
    val password: String = "",
    val age: String ="",

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
){

}
