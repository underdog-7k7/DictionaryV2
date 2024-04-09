package com.personal.animeshpandey.vocabpro.feature_dictionary.data.repository

import android.net.http.HttpException
import com.personal.animeshpandey.vocabpro.core.Resource
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.WordDAO
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DictionaryApi
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WordInfoRepoImpl (
    private val api: DictionaryApi,
    private val dao: WordDAO
): WordRepository{
    override fun getWordInfo(word: String): Flow<Resource<List<WordModel>>> = flow {

        emit(Resource.Loading())

        val wordinfos = dao.getwordInfos(word).map {it.word }

        emit(Resource.Loading(data = wordinfos))


        try{
            val remotewords = api.getWordInfo(word)
            dao.deleteWords(wordinfos.map { it.word })
            dao.insertWords(wordinfos.map {  })
        }catch (e:retrofit2.HttpException){


        }catch (e:IOException){

        }

    }
}