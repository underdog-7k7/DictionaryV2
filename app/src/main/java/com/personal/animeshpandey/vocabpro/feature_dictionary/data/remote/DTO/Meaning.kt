package com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DTO

data class Meaning(
    val antonyms: List<String>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
)