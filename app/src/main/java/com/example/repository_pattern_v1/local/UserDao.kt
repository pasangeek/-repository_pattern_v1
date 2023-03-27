package com.example.repository_pattern_v1.local

import androidx.room.*
import com.example.repository_pattern_v1.model.User
import com.example.repository_pattern_v1.repository.UserRepositoryImpl

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User): Long // returns row Id on SUCCESS

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE from user_table")
    suspend fun deleteAllUsers()

}


