package model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User(
    val userName: String = "",
    val password: String = "",
    val age: String ="",

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
){

}
