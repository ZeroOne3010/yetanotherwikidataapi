package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class StatementProperty @JsonCreator constructor(
    @JsonProperty("data-type") val dataType: String,
    @JsonProperty("id") val id: PropertyId
)
