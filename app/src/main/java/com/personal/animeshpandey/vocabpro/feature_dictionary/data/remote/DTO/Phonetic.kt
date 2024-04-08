package com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DTO

data class Phonetic(
    val audio: String,
    val license: License?=null,
    val sourceUrl: String,
    val text: String
)