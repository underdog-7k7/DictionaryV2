package com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.Meaning
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel

@Entity
data class WordEntity(
    @PrimaryKey val ID:Int? = null,
    val word:String, //this is the name of the word, wordModel is the entire word object
    val phonetic:String,
    val origin:String,
    val meanings:List<Meaning>
){
    fun toWord(): WordModel{
        return WordModel(
            meanings = meanings,
            phonetic = phonetic,
            word = word,
            origin = origin
        )
    }
}