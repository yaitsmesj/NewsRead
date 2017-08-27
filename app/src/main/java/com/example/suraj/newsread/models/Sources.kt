package com.example.suraj.newsread.models

/**
 * Created by Suraj on 19-Aug-17.
 */
data class Sources(
        var status: String,
        var sources: Array<SourceData>
) {
    data class SourceData(
            var id: String,
            var name: String,
            var category: String,
            var urlsToLogos: Logos
    ) {
        data class Logos(
                var small: String,
                var medium: String,
                var large: String
        )
    }
}