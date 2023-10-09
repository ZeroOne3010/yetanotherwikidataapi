package io.github.zeroone3010.wikidata

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths

class WikidataTest : StringSpec({
    "Q1085 Prague should deserialize correctly" {
        // Create and start a mock server
        val mockServer = MockWebServer()
        mockServer.start()

        // Set up a mocked response
        val exampleJson = String(Files.readAllBytes(Paths.get("src/test/resources/Q1085example.json")))
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(exampleJson)
        mockServer.enqueue(response)

        // Define the supplier for the base URL
        val urlSupplier: () -> String = { mockServer.url("/").toString() }

        // Get the data:
        val wikidata = Wikidata("mytoken", urlSupplier)
        val result = wikidata.getItem("Q1085")

        // Assert the results:
        result!!.aliases["lv"] shouldBe arrayOf("Praha", "Prague", "Prag")

        result!!.descriptions["fr"] shouldBe "capitale de la Tchéquie"

        result!!.id shouldBe "Q1085"

        result!!.labels["en"] shouldBe "Prague"
        result!!.labels["fi"] shouldBe "Praha"

        result!!.siteLinks["dawiki"]!!.badges shouldBe arrayOf("Q17437798")
        result!!.siteLinks["dawiki"]!!.title shouldBe "Prag"
        result!!.siteLinks["dawiki"]!!.url shouldBe URI("https://da.wikipedia.org/wiki/Prag").toURL()

        result!!.statements["P10565"]!![0]!!.id shouldBe "Q1085$90AB5C1D-8E1D-401D-96CC-15A825EF7C72"
        result!!.statements["P10565"]!![0]!!.property.dataType shouldBe "external-id"
        result!!.statements["P10565"]!![0]!!.property.id shouldBe "P10565"
        result!!.statements["P10565"]!![0]!!.qualifiers shouldBe emptyArray<String>()
        result!!.statements["P10565"]!![0]!!.rank shouldBe "normal"
        result!!.statements["P10565"]!![0]!!.references shouldBe emptyArray<Reference>()
        result!!.statements["P10565"]!![0]!!.value.content shouldBe "381457"
        result!!.statements["P10565"]!![0]!!.value.type shouldBe "value"

        result!!.statements["P1082"]!![0]!!.qualifiers[0].value.content shouldBe mapOf(
            "calendarmodel" to "http://www.wikidata.org/entity/Q1985727",
            "precision" to 11,
            "time" to "+2016-01-01T00:00:00Z"
        )

        result!!.type shouldBe "item"

        // Shut down the mock server
        mockServer.shutdown()
    }
}
)
