package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Reference @JsonCreator constructor(
    @JsonProperty("hash") val hash: String,
    @JsonProperty("parts") val parts: List<ReferencePart>
)
