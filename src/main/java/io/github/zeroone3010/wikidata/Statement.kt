package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

typealias StatementId = String

data class Statement @JsonCreator constructor(
    @JsonProperty("id") val id: StatementId,
    @JsonProperty("rank") val rank: String,
    @JsonProperty("property") val property: StatementProperty,
    @JsonProperty("qualifiers") val qualifiers: List<Qualifier>,
    @JsonProperty("references") val references: List<Reference>,
    @JsonProperty("value") val value: StatementValue,
)
