package com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DTO

import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.Meaning

data class MeaningDTO(
    val definitions: List<DefinitionDTO>,
    val partsOfSpeech:String
){
    fun toMeaningModel(): Meaning {
        return Meaning(
            definitions = definitions.map { it.toDefinitionObject() },
            partsOfSpeech = partsOfSpeech
        )
    }
}