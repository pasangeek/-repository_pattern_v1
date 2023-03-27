package com.example.repository_pattern_v1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class UserResponse(
    var page: Int,
    @SerializedName("per_page")
    var perPage : Int,
    var total : Int,
    @SerializedName("total_pages")
    var totalPages : Int,
    var data : List<User>,
    var support : Support
)

@Entity(tableName = "user_table")
data class User(
 @PrimaryKey(autoGenerate = true)
    var id: Int,
    var email : String,
    @SerializedName("first_name")
 @ColumnInfo(name = "first_name")
    var firstName : String,
@ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    var lastName : String,
    var avatar : String
)

data class Support(
    var url : String,
    var text: String
)