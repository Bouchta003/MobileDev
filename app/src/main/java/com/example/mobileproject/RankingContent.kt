package com.example.mobileproject

class RankingContent {
    var rank: Int = 0
    var name: String = ""
    var lastName: String =""
    var score: Int = 0

    data class RankingItem(val rank: Int, val name: String, val lastName: String, val score: Int)

}
