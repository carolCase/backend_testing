package controller

import model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController {

    @GetMapping("/member")
    fun member(): User {
        return User(userName = "Carolina", password = "123", age = "42", id = null )
    }
}