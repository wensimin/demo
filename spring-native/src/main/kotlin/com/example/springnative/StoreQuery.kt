package com.example.springnative

data class StoreQuery(
    @Like(Like.Type.ALL)
    // https://github.com/spring-projects-experimental/spring-native/issues/1570
//    @field:Length(max = 10)
    val value: String?
)
//    : QueryParam
