package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Qualifier @JsonCreator constructor(
    @JsonProperty("property") val property: StatementProperty,
    @JsonProperty("value") val value: QualifierValue
)
