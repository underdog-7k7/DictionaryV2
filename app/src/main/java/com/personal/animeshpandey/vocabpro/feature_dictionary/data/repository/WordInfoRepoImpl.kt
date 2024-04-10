package com.personal.animeshpandey.vocabpro.feature_dictionary.data.repository

import com.personal.animeshpandey.vocabpro.core.Resource
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.WordDAO
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DictionaryApi
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException


//the repository decides which source of data to use internet, or cache
class WordInfoRepoImpl (
    private val api: DictionaryApi,
    private val dao: WordDAO
): WordRepository{
    override fun getWordInfo(word: String): Flow<Resource<List<WordModel>>> = flow {

        emit(Resource.Loading())

        val wordinfos = dao.getwordInfos(word).map {it.toWord() }
        emit(Resource.Loading(data = wordinfos))


        try{
            val remotewords = api.getWordInfo(word)

            dao.deleteWords(remotewords.map { it.word })
            dao.insertWords(remotewords.map { it.toWord()})
        }catch (e:retrofit2.HttpException){
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = wordinfos
            ))
        }catch (e:IOException){
            emit(Resource.Error(
                message = "Can't Fetch from servers, check connection!",
                data = wordinfos
            ))
        }
        val newWordInfos =  dao.getwordInfos(word).map{it.toWord()}
        emit(Resource.Success(newWordInfos))
    }
}