package com.example.repository_pattern_v1.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repository_pattern_v1.model.User
import com.example.repository_pattern_v1.repository.UserRepositoryImpl

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: UserRepositoryImpl): UserDatabase {

            return INSTANCE
                ?: synchronized(this) {
                    INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java, "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                        .also { INSTANCE = it }
                }
        }
    }

}