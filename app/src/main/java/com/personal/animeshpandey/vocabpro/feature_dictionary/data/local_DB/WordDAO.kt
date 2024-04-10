package com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.Entity.WordEntity
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.WordModel

@Dao
interface WordDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(words:List<WordEntity>)

    @Query("DELETE FROM wordentity WHERE word IN(:words)")  //tablename should be same as the entitity name which here is wordentity
    suspend fun deleteWords(words:List<String>)

    @Query("SELECT * FROM wordentity WHERE word LIKE '%' || :word || '%'")
    suspend fun getwordInfos(word:String):List<WordEntity>


}