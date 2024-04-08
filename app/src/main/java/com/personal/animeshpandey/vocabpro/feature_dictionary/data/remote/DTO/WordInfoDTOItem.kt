package com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DTO

data class WordInfoDTOItem(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
)