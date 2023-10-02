package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

typealias PropertyId = String

data class Property @JsonCreator constructor(
    @JsonProperty("id") val id: PropertyId,
    @JsonProperty("type") val type: String,
    @JsonProperty("data-type") val dataType: String,
    @JsonProperty("labels") val labels: Map<String, String>,
    @JsonProperty("descriptions") val descriptions: Map<String, String>,
    @JsonProperty("aliases") val aliases: Map<String, List<String>>,
    @JsonProperty("statements") val statements: Map<String, List<Statement>>,
)
