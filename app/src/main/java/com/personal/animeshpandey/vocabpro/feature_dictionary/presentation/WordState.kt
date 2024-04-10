package com.personal.animeshpandey.vocabpro.feature_dictionary.presentation

import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel

data class WordState(
    val wordInfoItems: List<WordModel> = emptyList(),
    val isLoading: Boolean = false
){

}