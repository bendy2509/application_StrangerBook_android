package com.example.strangerbook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.strangerbook.data.model.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCard(
    post: Post,
    onPostClick: () -> Unit = {},
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    var isLiked by remember { mutableStateOf(false) }
    var likeCount by remember { mutableStateOf(post.likes) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .shadow(
                elevation = 4.dp,
                shape = MaterialTheme.shapes.medium,
                clip = true
            ),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        onClick = onPostClick
    ) {
        Column {
            // User header avec fond subtil
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f),
                                Color.Transparent
                            )
                        )
                    )
            ) {
                UserHeader(
                    user = post.user,
                    timestamp = post.timestamp
                )
            }

            // Contenu avec padding amélioré
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = post.content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.2
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Image avec gestion d'erreur
                post.imageUrl?.let { imageUrl ->
                    Spacer(modifier = Modifier.height(12.dp))
                    ImageWithFallback(
                        imageUrl = imageUrl,
                        contentDescription = "Post image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Stats d'engagement améliorées
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    EngagementStat(
                        count = likeCount,
                        label = "J'aime",
                        color = if (isLiked) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    EngagementStat(
                        count = post.comments,
                        label = "Commentaires",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    EngagementStat(
                        count = post.shares,
                        label = "Partages",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Barre de séparation stylisée
                Divider(
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Boutons d'action améliorés
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = if (isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        text = "J'aime",
                        isActive = isLiked,
                        activeColor = MaterialTheme.colorScheme.error,
                        onClick = {
                            isLiked = !isLiked
                            likeCount = if (isLiked) likeCount + 1 else likeCount - 1
                            onLikeClick()
                        }
                    )

                    ActionButton(
                        icon = Icons.Default.ChatBubbleOutline,
                        text = "Commenter",
                        onClick = onCommentClick
                    )

                    ActionButton(
                        icon = Icons.Default.Share,
                        text = "Partager",
                        onClick = onShareClick
                    )
                }
            }
        }
    }
}

// Composant image avec fallback
@Composable
fun ImageWithFallback(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            // Placeholder pendant le chargement ou en cas d'erreur
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = "Chargement de l'image",
                        modifier = Modifier.size(36.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (state is AsyncImagePainter.State.Loading) "Chargement..." else "Image non disponible",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                }
            }
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}

@Composable
fun EngagementStat(
    count: Int,
    label: String,
    color: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = formatCount(count),
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                color = color
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        )
    }
}

@Composable
fun ActionButton(
    icon: ImageVector,
    text: String,
    isActive: Boolean = false,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    val buttonColor = if (isActive) activeColor else MaterialTheme.colorScheme.onSurfaceVariant

    TextButton(
        onClick = onClick,
        modifier = Modifier.height(48.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = buttonColor
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}

private fun formatCount(count: Int): String {
    return when {
        count >= 1000000 -> "${count / 1000000}M"
        count >= 1000 -> "${count / 1000}K"
        else -> count.toString()
    }
}