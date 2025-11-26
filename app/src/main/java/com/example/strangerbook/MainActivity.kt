package com.example.strangerbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.strangerbook.data.model.Post
import com.example.strangerbook.ui.screens.FeedScreen
import com.example.strangerbook.ui.screens.SearchScreen
import com.example.strangerbook.ui.screens.TeamScreen
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
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf("feed") }
    val context = LocalContext.current

    when (currentScreen) {
        "feed" -> {
            FeedScreen(
                onPostClick = { post -> handlePostClick(post, context) },
                onLikeClick = { post -> handleLikeClick(post, context) },
                onCommentClick = { post -> handleCommentClick(post, context) },
                onShareClick = { post -> handleShareClick(post, context) },
                onSearchClick = {
                    println("Ouverture de l'écran de recherche")
                    currentScreen = "search"
                },
                onTeamClick = {
                    println("Ouverture de l'écran équipe")
                    currentScreen = "team"
                }
            )
        }
        "search" -> {
            SearchScreen(
                onBackClick = {
                    println("Retour au feed")
                    currentScreen = "feed"
                },
                onPostClick = { post -> handlePostClick(post, context) },
                onLikeClick = { post -> handleLikeClick(post, context) },
                onCommentClick = { post -> handleCommentClick(post, context) },
                onShareClick = { post -> handleShareClick(post, context) }
            )
        }
        "team" -> {
            TeamScreen(
                onBackClick = {
                    println("Retour au feed")
                    currentScreen = "feed"
                }
            )
        }
    }
}

private fun handlePostClick(post: Post, context: android.content.Context) {
    println("Post: ${post.id} par ${post.user.name}")
    android.widget.Toast.makeText(
        context,
        "Post de ${post.user.name}",
        android.widget.Toast.LENGTH_SHORT
    ).show()
}

private fun handleLikeClick(post: Post, context: android.content.Context) {
    println("J'aime: ${post.id}")
    android.widget.Toast.makeText(
        context,
        "❤️ Vous aimez le post de ${post.user.name}",
        android.widget.Toast.LENGTH_SHORT
    ).show()
}

private fun handleCommentClick(post: Post, context: android.content.Context) {
    println("Commentaire: ${post.id}")
    android.widget.Toast.makeText(
        context,
        "💬 Commenter le post de ${post.user.name}",
        android.widget.Toast.LENGTH_SHORT
    ).show()
}

private fun handleShareClick(post: Post, context: android.content.Context) {
    println("Partage: ${post.id}")

    val shareIntent = android.content.Intent().apply {
        action = android.content.Intent.ACTION_SEND
        putExtra(android.content.Intent.EXTRA_TEXT, "Découvrez ce post de ${post.user.name} sur Stranger Book: \"${post.content.take(50)}...\"")
        type = "text/plain"
    }
    context.startActivity(android.content.Intent.createChooser(shareIntent, "Partager via"))

    android.widget.Toast.makeText(
        context,
        "📤 Partage du post",
        android.widget.Toast.LENGTH_SHORT
    ).show()
}