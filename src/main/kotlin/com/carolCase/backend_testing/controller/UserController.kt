package com.carolCase.backend_testing.controller


import com.carolCase.backend_testing.model.User
import com.carolCase.backend_testing.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/member")
class UserController(@Autowired private val userRepository: UserRepository) {

    @PostMapping
    fun addMember(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @GetMapping
    fun getAllMembers(): List<User>{
      return userRepository.findAll()
    }

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: Long , @RequestBody user: User): User {
       val existingUser = userRepository.findById(id)
           .orElseThrow { Exception("User not found with id: $id") }
        val updateUser = existingUser.copy(
            userName = user.userName,
            password = user.password,
            age = user.age
        )
        return userRepository.save(updateUser)
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): String{
    val existingUser = userRepository.findById(id)
        .orElseThrow { Exception("User not found with id: $id") }
        userRepository.delete(existingUser)
        return "user with id $id successfully deleted"
    }




}