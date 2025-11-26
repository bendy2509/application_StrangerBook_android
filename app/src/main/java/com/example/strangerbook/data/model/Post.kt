package com.example.strangerbook.data.model

data class Post(
    val id: String,
    val user: User,
    val content: String,
    val imageUrl: String? = null,
    val timestamp: String,
    val likes: Int = 0,
    val comments: Int = 0,
    val shares: Int = 0
)