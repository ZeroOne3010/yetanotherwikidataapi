package io.github.zeroone3010.wikidata


class WikidataTestRunner {
    object WikidataTestRunner {
        @JvmStatic
        fun main(args: Array<String>) {
            val wikidata = Wikidata(args[0])
            val item = wikidata.getItem("Q1085")

            println(item)
        }
    }
}
