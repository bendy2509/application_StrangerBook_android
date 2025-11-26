package com.example.strangerbook.data.repository

import com.example.strangerbook.data.DataSource
import com.example.strangerbook.data.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepository {
    fun getPosts(): Flow<List<Post>> = flow {
        emit(DataSource.samplePosts)
    }

    fun getPostsStream(): Flow<List<Post>> = flow {
        while (true) {
            emit(DataSource.samplePosts.shuffled())
            kotlinx.coroutines.delay(5000) // Simulate updates
        }
    }
}