package com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model


//val phonetics: List<PhoneticDTO> We dont need a list currently so we dont design a model that we
//it however does get represented in the DTO If we need that feature in the future and we need to make a model out of it
data class WordModel(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)