package com.example.repository_pattern_v1.model

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

//@Entity(tableName = "user_table") // Remove
data class User(
    //   @PrimaryKey(autoGenerate = true) // Remove
    var id: Int,
    var email : String,
    @SerializedName("first_name")
    // @ColumnInfo(name = "first_name") // Remove
    var firstName : String,
    //@ColumnInfo(name = "last_name") // Remove
    @SerializedName("last_name")
    var lastName : String,
    var avatar : String
)

data class Support(
    var url : String,
    var text: String
)