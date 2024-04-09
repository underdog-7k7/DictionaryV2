package com.personal.animeshpandey.vocabpro.core

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.personal.animeshpandey.vocabpro.feature_dictionary.domain.model.Meaning
import androidx.annotation.StringRes


@ProvidedTypeConverter
class converters(private val myjsonparser:JSON_Parser){

    @TypeConverter
    fun fromMeaningsJSON(json:String):List<Meaning>{
        return myjsonparser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>):String{
        return myjsonparser.toJson(
            meanings,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?:"[]" //empty json
    }
}

typealias SimpleResource = Resource<Unit>

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}