package com.example.strangerbook.data.model

data class User(
    val id: String,
    val name: String,
    val username: String,
    val profileImage: String = "",
    val isVerified: Boolean = false
)