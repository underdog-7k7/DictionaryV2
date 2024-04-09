package com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DTO

import com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.Entity.WordEntity
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel

data class WordInfoDto(
    val meanings: List<MeaningDTO>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDTO>,
    val word: String
) {
    fun toWordModel(): WordModel {
        //only 4 features of the DTO rather than 5 are used
        //only DTO's interact with DTO's

        return WordModel(
            meanings = meanings.map{it.toMeaningModel()},
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }

    fun toWordEntity():WordEntity{
        return WordEntity(
            meanings = meanings.map{it.toMeaningModel()},
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}