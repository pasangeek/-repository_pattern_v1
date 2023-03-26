package com.example.repository_pattern_v1.repository

interface UserRepository {

    suspend fun getUsers() : List<User>

}