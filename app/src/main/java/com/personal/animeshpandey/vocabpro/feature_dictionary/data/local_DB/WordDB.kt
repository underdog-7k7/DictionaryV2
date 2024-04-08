package com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.Entity.WordEntity


@Database(
    entities = [WordEntity::class],
    version = 1 //everytime database is update version is incremented
)

abstract class WordDB:RoomDatabase() {
    abstract val dao: WordDAO
}