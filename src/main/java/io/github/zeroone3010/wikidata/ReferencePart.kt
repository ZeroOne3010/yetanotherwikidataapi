package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ReferencePart @JsonCreator constructor(
    @JsonProperty("property") val property: StatementProperty,
    @JsonProperty("value") val value: ReferenceValue
)
