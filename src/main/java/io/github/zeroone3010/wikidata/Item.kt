package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

typealias ItemId = String

data class Item @JsonCreator constructor(
    @JsonProperty("id") val id: ItemId,
    @JsonProperty("labels") val labels: Map<String, String>,
    @JsonProperty("descriptions") val descriptions: Map<String, String>,
    @JsonProperty("aliases") val aliases: Map<String, List<String>>,
    @JsonProperty("sitelinks") val siteLinks: Map<String, SiteLink>,
    @JsonProperty("statements") val statements: Map<String, List<Statement>>,
    @JsonProperty("type") val type: String,
)
