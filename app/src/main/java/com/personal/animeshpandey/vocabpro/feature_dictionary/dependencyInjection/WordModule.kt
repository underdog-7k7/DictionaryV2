package com.personal.animeshpandey.vocabpro.feature_dictionary.dependencyInjection

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.personal.animeshpandey.vocabpro.core.GsonParser
import com.personal.animeshpandey.vocabpro.core.converters
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.local_DB.WordDB
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.remote.DictionaryApi
import com.personal.animeshpandey.vocabpro.feature_dictionary.data.repository.WordInfoRepoImpl
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.repository.WordRepository
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.usecase.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordModule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordDB,
        api: DictionaryApi
    ): WordRepository {
        return WordInfoRepoImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordDB {
        return Room.databaseBuilder(
            app, WordDB::class.java, "word_db"
        ).addTypeConverter(converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}