package com.carolCase.backend_testing.controller


import com.carolCase.backend_testing.model.User
import com.carolCase.backend_testing.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*


@RestController
@RequestMapping("/member")
class UserController(@Autowired val userRepository: UserRepository) {

    @PostMapping
    fun addMember(@RequestBody user: User): User {
      return userRepository.save(user)

    }

    @GetMapping
    fun getAllMembers(): MutableList<User>{
      return userRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): ResponseEntity<User>{
        val specificMember = userRepository.findById(id)

       return  if (specificMember.isPresent){
            ResponseEntity.ok(specificMember.get())
       }else {
           ResponseEntity.notFound().build()
       }
    }


    @PutMapping("/{id}")
    fun updateMember(@PathVariable("id") id: Long , @RequestBody user: User): User {
       val existingUser = userRepository.findById(id)
           .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "user not found with id: $id") }
        val updateUser = existingUser.copy(
            userName = user.userName,
            password = user.password,
            age = user.age
        )
        return userRepository.save(updateUser)
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable("id") id: Long): String {
        println("Attempting to delete user with ID: $id")
        val existingUser = userRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: $id") }
        userRepository.delete(existingUser)
        println("User with ID $id deleted successfully")
        return "User with id $id successfully deleted"
    }





}