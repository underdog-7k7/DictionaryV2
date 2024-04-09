package com.personal.animeshpandey.vocabpro.core

import java.lang.reflect.Type

interface JSON_Parser {
    //to convert to and from JSON Type
        fun <T> fromJson(json: String, type: Type): T?

        fun <T> toJson(obj: T, type: Type): String?

}