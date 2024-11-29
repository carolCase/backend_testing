package com.carolCase.backend_testing.repository

import com.carolCase.backend_testing.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>