package com.example.kotlinDemo.pairProgramming

/**
 * Helper Model to map the given input based on the key
 */
data class MapperFields(
    val category: String,
    val name: String)


//Mutable map - <String, mapperField>

//define category by grouping the keys like Hi, Hello etc - Greetings
//Farewells - Bye,
//Mood

//mutable map key corresponds to the keys in JSON
//mapperField - category -
// name - ola, (translation)

/*
{
  item1: "hello"
  item2: "goodBye"
  item3: "estutendo"
  item4: "Bonjour"
}

return a List - grouping by category, each object in the list will have the category
key - would be name - value - {hello}

[Greetings [{English, hello}, {French, Bonjeur}]]
 */

val mapperFieldMap: MutableMap<String, MapperFields> = mutableMapOf(
    "item1" to MapperFields(category = "Greetings", name = "English"),
    "item2" to MapperFields(category = "Farewell", name = "English"),
    "item3" to MapperFields(category = "Mood", name = "Spanish"),
    "item4" to MapperFields(category = "Greetings", name = "French"),
)

/**
 * Output Data Model
 */

data class OutputCategoryFields(
    val category : String,
    val values: List<Pair<String, String>>
)

/**
 * Function to modify the input into the output data model
 */
fun groupByCategory(map: Map<String, MapperFields>, data:Map<String, String>) : List<OutputCategoryFields> {
    val groupedMap = data.entries.groupBy { entry -> map[entry.key]?.category?:"Unknown" }

    return groupedMap.map { (category, entries) -> OutputCategoryFields(
        category, entries.map { it.value to (map[it.key]?.name?:"Unknown") }
    ) }
}




