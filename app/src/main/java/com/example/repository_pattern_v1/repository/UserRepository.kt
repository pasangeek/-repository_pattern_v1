package com.example.repository_pattern_v1.repository

import com.example.repository_pattern_v1.model.User

interface UserRepository {

    suspend fun getUsers() : List<User>

}