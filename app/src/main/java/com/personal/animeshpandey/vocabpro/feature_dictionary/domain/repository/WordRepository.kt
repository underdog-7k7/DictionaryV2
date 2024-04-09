package com.personal.animeshpandey.vocabpro.feature_dictionary.domain.repository

import com.personal.animeshpandey.vocabpro.core.Resource
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel
import kotlinx.coroutines.flow.Flow

//THE repository has the job of deciding which source of data to use and forward to the viewmodel
//either use the internet(if avaialble) else caching(the DB we setup)
//implements SSOT , Single source of truth
interface WordRepository{
    fun getWordInfo(word:String): Flow<Resource<List<WordModel>>>
}