package com.example.strangerbook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.strangerbook.data.DataSource
import com.example.strangerbook.data.model.Post
import com.example.strangerbook.ui.components.FeedHeader
import com.example.strangerbook.ui.components.PostCard
import com.example.strangerbook.ui.theme.StrangerBookTheme
import kotlinx.coroutines.delay // ✅ IMPORT MANQUANT AJOUTÉ

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    posts: List<Post> = DataSource.samplePosts,
    onPostClick: (Post) -> Unit = {},
    onLikeClick: (Post) -> Unit = {},
    onCommentClick: (Post) -> Unit = {},
    onShareClick: (Post) -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    var refreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = refreshing) {
        if (refreshing) {
            delay(1000) // ✅ CORRIGÉ : plus besoin de kotlinx.coroutines.delay
            refreshing = false
        }
    }

    Scaffold(
        topBar = {
            FeedHeader(onSearchClick = onSearchClick)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = posts,
                key = { it.id }
            ) { post ->
                PostCard(
                    post = post,
                    onPostClick = { onPostClick(post) },
                    onLikeClick = { onLikeClick(post) },
                    onCommentClick = { onCommentClick(post) },
                    onShareClick = { onShareClick(post) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))

                // Loading indicator at the end
                if (refreshing) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    StrangerBookTheme {
        FeedScreen(
            onPostClick = { println("Post: ${it.id}") },
            onLikeClick = { println("Like: ${it.id}") },
            onCommentClick = { println("Comment: ${it.id}") },
            onShareClick = { println("Share: ${it.id}") },
            onSearchClick = { println("Search") }
        )
    }
}