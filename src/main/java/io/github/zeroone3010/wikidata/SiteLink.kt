package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL

data class SiteLink @JsonCreator constructor(
    @JsonProperty("badges") val badges: List<String>,
    @JsonProperty("title") val title: String,
    @JsonProperty("url") val url: URL
)
