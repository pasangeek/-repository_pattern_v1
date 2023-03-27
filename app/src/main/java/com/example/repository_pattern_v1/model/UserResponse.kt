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



