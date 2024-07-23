### Pair Programming Question

There is a data model given to hold called mapperFields
{
   category : String,
   name : String
}

The input structure to the function is 

{
item1: "hello",
item2: "goodBye",
item3: "estutendo",
item4: "Bonjour"
}

val mapperFieldMap: MutableMap<String, MapperFields> = mutableMapOf(
"item1" to MapperFields(category = "Greetings", name = "English"),
"item2" to MapperFields(category = "Farewell", name = "English"),
"item3" to MapperFields(category = "Mood", name = "Spanish"),
"item4" to MapperFields(category = "Greetings", name = "French"),
)

The task is to map the keys of the input structure to the keys of the mapperFieldMap and project the output of the below structure

[Greetings [{hello, English}, {Bonjeur, French}], Farewell [{goodBye, English}], Mood [{estutendo, Spanish}]]