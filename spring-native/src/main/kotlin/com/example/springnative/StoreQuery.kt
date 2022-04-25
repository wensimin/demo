package com.example.springnative

import org.hibernate.validator.constraints.Length

data class StoreQuery(
    @Like(Like.Type.ALL)
    @field:Length(max = 10)
    val value: String?
) : QueryParam
