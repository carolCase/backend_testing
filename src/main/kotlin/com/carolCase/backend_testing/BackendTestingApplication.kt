package com.carolCase.backend_testing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class BackendTestingApplication{

	@GetMapping
	fun greeting()= "Benny was here!"

}

fun main(args: Array<String>) {
	runApplication<BackendTestingApplication>(*args)
}
