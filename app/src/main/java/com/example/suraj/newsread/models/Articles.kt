package com.example.suraj.newsread.models

/**
 * Created by Suraj on 09-Aug-17.
 */
data class Articles(
        var status: String,
        var source: String,
        var sortBy: String,
        var articles: Array<BaseNews>
){

    data class BaseNews (
            var author: String,
            var title: String,
            var description: String,
            var url: String,
            var urlToImage: String,
            var publishedAt: String
    )
}