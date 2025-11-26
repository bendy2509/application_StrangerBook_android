package com.example.strangerbook.data

import com.example.strangerbook.data.model.Post
import com.example.strangerbook.data.model.User

object DataSource {
    val sampleUsers = listOf(
        User(
            id = "1",
            name = "Mike Wheeler",
            username = "mike_wheels",
            isVerified = true
        ),
        User(
            id = "2",
            name = "Eleven",
            username = "el",
            isVerified = true
        ),
        User(
            id = "3",
            name = "Dustin Henderson",
            username = "dustin_d",
            isVerified = false
        ),
        User(
            id = "4",
            name = "Lucas Sinclair",
            username = "lucas_s",
            isVerified = false
        ),
        User(
            id = "5",
            name = "Will Byers",
            username = "will_the_wise",
            isVerified = true
        ),
        User(
            id = "6",
            name = "Max Mayfield",
            username = "madmax",
            isVerified = true
        ),
        User(
            id = "7",
            name = "Steve Harrington",
            username = "steve_hair",
            isVerified = false
        ),
        User(
            id = "8",
            name = "Nancy Wheeler",
            username = "nancy_w",
            isVerified = true
        )
    )

    val samplePosts = listOf(
        // Posts avec images réelles
        Post(
            id = "1",
            user = sampleUsers[0],
            content = "Just discovered something strange in the woods behind my house. Anyone else seen weird lights at night? 🔦",
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?ixlib=rb-4.0.3&w=600",
            timestamp = "2 hours ago",
            likes = 42,
            comments = 8,
            shares = 3
        ),
        Post(
            id = "2",
            user = sampleUsers[1],
            content = "Learning about this world. Friends make everything better. 🧇",
            imageUrl = "https://images.unsplash.com/photo-1567620905732-2d1ec7ab7445?ixlib=rb-4.0.3&w=600",
            timestamp = "5 hours ago",
            likes = 128,
            comments = 15,
            shares = 7
        ),
        Post(
            id = "3",
            user = sampleUsers[2],
            content = "Nouvelle campagne D&D ce weekend ! Qui est prêt à affronter le Demogorgon ? 🎲",
            timestamp = "1 day ago",
            likes = 56,
            comments = 12,
            shares = 2
        ),
        Post(
            id = "4",
            user = sampleUsers[3],
            content = "Practice paid off! Hit my target from 50 feet away. Never underestimate a good slingshot. 🎯",
            imageUrl = "https://images.unsplash.com/photo-1551698618-1dfe5d97d256?ixlib=rb-4.0.3&w=600",
            timestamp = "1 day ago",
            likes = 34,
            comments = 5,
            shares = 1
        ),
        Post(
            id = "5",
            user = sampleUsers[4],
            content = "Parfois, j'ai encore l'impression d'être dans l'Upside Down. Mais mes amis me gardent les pieds sur terre. 🎨",
            imageUrl = "https://images.unsplash.com/photo-1541961017774-22349e4a1262?ixlib=rb-4.0.3&w=600",
            timestamp = "2 days ago",
            likes = 89,
            comments = 20,
            shares = 4
        ),

        // Nouveaux posts supplémentaires
        Post(
            id = "6",
            user = sampleUsers[5],
            content = "New high score at the arcade today! 🎮 Who wants to challenge me?",
            imageUrl = "https://images.unsplash.com/photo-1486572788966-cfd3df1f5b42?ixlib=rb-4.0.3&w=600",
            timestamp = "3 hours ago",
            likes = 67,
            comments = 9,
            shares = 2
        ),
        Post(
            id = "7",
            user = sampleUsers[6],
            content = "Je viens de trouver un nouveau produit pour mes cheveux. Game changer ! 💇‍♂️",
            timestamp = "6 hours ago",
            likes = 154,
            comments = 23,
            shares = 8
        ),
        Post(
            id = "8",
            user = sampleUsers[7],
            content = "Working on a new story for the school newspaper. Big things coming! 📰",
            imageUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?ixlib=rb-4.0.3&w=600",
            timestamp = "1 day ago",
            likes = 78,
            comments = 14,
            shares = 3
        ),
        Post(
            id = "9",
            user = sampleUsers[0],
            content = "Quelqu'un a-t-il des recommandations de films d'horreur ? J'ai besoin de nouvelles idées pour le club de cinéma. 🎬",
            timestamp = "1 day ago",
            likes = 45,
            comments = 18,
            shares = 5
        ),
        Post(
            id = "10",
            user = sampleUsers[2],
            content = "Just finished building a new radio transmitter. The range is incredible! 📡 #ScienceRules",
            imageUrl = "https://images.unsplash.com/photo-1581094794329-c8112a89af12?ixlib=rb-4.0.3&w=600",
            timestamp = "2 days ago",
            likes = 92,
            comments = 11,
            shares = 4
        ),
        Post(
            id = "11",
            user = sampleUsers[5],
            content = "Ça y est, j'ai enfin réussi ce niveau impossible de Dragon's Lair ! 🐉",
            imageUrl = "https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&w=600",
            timestamp = "2 days ago",
            likes = 113,
            comments = 27,
            shares = 6
        ),
        Post(
            id = "12",
            user = sampleUsers[3],
            content = "Entraînement d'arc aujourd'hui. La précision s'amliore ! 🏹 #NeverMiss",
            timestamp = "3 days ago",
            likes = 61,
            comments = 7,
            shares = 1
        ),
        Post(
            id = "13",
            user = sampleUsers[1],
            content = "J'ai découvert les Eggos. Ma vie ne sera plus jamais la même. 🧇❤️",
            imageUrl = "https://images.unsplash.com/photo-1571868095890-6d13ceed6a16?ixlib=rb-4.0.3&w=600",
            timestamp = "3 days ago",
            likes = 245,
            comments = 42,
            shares = 15
        ),
        Post(
            id = "14",
            user = sampleUsers[6],
            content = "Babysitting again tonight. These kids are something else... 😅",
            timestamp = "4 days ago",
            likes = 88,
            comments = 16,
            shares = 3
        ),
        Post(
            id = "15",
            user = sampleUsers[4],
            content = "My new artwork is coming along nicely. Can't wait to show you all! 🎨✨",
            imageUrl = "https://images.unsplash.com/photo-1541961017774-22349e4a1262?ixlib=rb-4.0.3&w=600",
            timestamp = "4 days ago",
            likes = 134,
            comments = 29,
            shares = 7
        )
    )
}