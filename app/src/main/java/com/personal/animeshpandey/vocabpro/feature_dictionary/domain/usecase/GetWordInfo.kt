package com.personal.animeshpandey.vocabpro.feature_dictionary.domain.usecase

import com.personal.animeshpandey.vocabpro.core.Resource
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordModel>>> {
        if(word.isBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}