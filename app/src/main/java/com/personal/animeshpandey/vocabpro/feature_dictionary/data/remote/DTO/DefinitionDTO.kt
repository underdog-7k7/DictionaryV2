package com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DTO

import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.Definition


//DTO Is Data transfer object, it essentially converts the object from transmission friendly unit to a model unit
//we may not need to map all DTO's to a model in our app , it depends on how much functionality we want
data class DefinitionDTO(
    val antonyms: List<String>,
    val definition: String,
    val example: String?, //Some words may not have an example so nullable
    val synonyms: List<String>
){
    fun toDefinitionObject():Definition{
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}