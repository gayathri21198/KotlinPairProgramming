package com.example.kotlinDemo

import com.example.kotlinDemo.pairProgramming.MapperFields
import com.example.kotlinDemo.pairProgramming.OutputCategoryFields
import com.example.kotlinDemo.pairProgramming.groupByCategory
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class MapperFieldTest {

  /*  {
        item1: "hello"
        item2: "goodBye"
        item3: "estutendo"
        item4: "Bonjeur"
    } */

    /*
    [Greetings [{English, hello}, {French, Bonjeur}]]
     */

    /*
    data class OutputCategoryFields(
    val category : String,
    val values: List<Pair<String, String>>
)
     */

    @Test
    fun testGroupingByCategory() {
        val mapperFieldMap: MutableMap<String, MapperFields> = mutableMapOf(
            "item1" to MapperFields(category = "Greetings", name = "English"),
            "item2" to MapperFields(category = "Farewell", name = "English"),
            "item3" to MapperFields(category = "Mood", name = "Spanish"),
            "item4" to MapperFields(category = "Greetings", name = "French"),
        )

        val mapperFieldMapInput: MutableMap<String, String> = mutableMapOf(
            "item1" to "hello",
            "item2" to "goodBye",
            "item3" to "estutendo",
            "item4" to "Bonjour"
        )

        val mapperFieldMapExpectedOutput = listOf<OutputCategoryFields>(
            OutputCategoryFields("Greetings", listOf(Pair("hello" , "English"), Pair("Bonjour", "French"))),
            OutputCategoryFields("Farewell", listOf(Pair("goodBye" , "English"))),
            OutputCategoryFields("Mood", listOf(Pair("estutendo" , "Spanish")))
        )

        val result = groupByCategory(mapperFieldMap, mapperFieldMapInput)
        assertEquals(expected = mapperFieldMapExpectedOutput, actual = result, message="Obtained the expected output")
    }

}