package io.github.zeroone3010.wikidata

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

private const val BASE_URL = "https://www.wikidata.org/w/rest.php/wikibase/v0/entities/"

class Wikidata(private val bearerToken: String,
    private val baseUrlSupplier: () -> String = {BASE_URL}) {

    private val objectMapper: ObjectMapper = ObjectMapper()
    private val client = OkHttpClient()

    fun getItem(itemId: ItemId): Item? {
        val request = Request.Builder()
            .url("${baseUrlSupplier()}items/$itemId")
            .addHeader("Authorization", "Bearer $bearerToken")
            .build()

        client.newCall(request).execute().use { response ->
            if (response.code == 404) {
                return null
            }
            if (!response.isSuccessful) {
                println("Request failed: ${response.code} ${response.message}")
                throw RuntimeException(response.message)
            }

            val responseBody = response.body?.string() ?: throw RuntimeException("Empty response body")
            val item: Item = objectMapper.readValue(responseBody)
            return item
        }
    }

    fun getProperty(propertyId: PropertyId): Property? {
        val request = Request.Builder()
            .url("${baseUrlSupplier()}properties/$propertyId")
            .addHeader("Authorization", "Bearer $bearerToken")
            .build()

        client.newCall(request).execute().use { response ->
            if (response.code == 404) {
                return null
            }
            if (!response.isSuccessful) {
                println("Request failed: ${response.message}")
                throw RuntimeException(response.message)
            }

            val responseBody = response.body?.string() ?: throw RuntimeException("Empty response body")
            val property: Property = objectMapper.readValue(responseBody)
            return property
        }
    }
}
