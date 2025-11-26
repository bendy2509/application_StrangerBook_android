package com.example.strangerbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.strangerbook.data.model.Post
import com.example.strangerbook.ui.screens.FeedScreen
import com.example.strangerbook.ui.theme.StrangerBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrangerBookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FeedScreen(
                        onPostClick = { post -> handlePostClick(post) },
                        onLikeClick = { post -> handleLikeClick(post) },
                        onCommentClick = { post -> handleCommentClick(post) },
                        onShareClick = { post -> handleShareClick(post) },
                        onSearchClick = { handleSearchClick() }
                    )
                }
            }
        }
    }

    private fun handlePostClick(post: Post) {
        println("📱 Post clicked: ${post.id} by ${post.user.name}")
    }

    private fun handleLikeClick(post: Post) {
        println("❤️ Like clicked for post: ${post.id}")
    }

    private fun handleCommentClick(post: Post) {
        println("💬 Comment clicked for post: ${post.id}")
    }

    private fun handleShareClick(post: Post) {
        println("🔄 Share clicked for post: ${post.id}")
    }

    private fun handleSearchClick() {
        println("🔍 Search clicked")
    }
}