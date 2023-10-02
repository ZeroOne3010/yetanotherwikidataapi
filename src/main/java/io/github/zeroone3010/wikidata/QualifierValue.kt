package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class QualifierValue @JsonCreator constructor(
    @JsonProperty("content") val content: Any?, // It's either String or a Map<String, Object>, or it could be missing
    @JsonProperty("type") val type: String
)
