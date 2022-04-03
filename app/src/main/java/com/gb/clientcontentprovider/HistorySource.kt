package com.gb.clientcontentprovider

import android.content.ContentResolver
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri


const val ID = "id"
const val NAME = "NAME"
const val TEMPERATURE = "TEMPERATURE"
const val FEELS_LIKE = "FEELS_LIKE"
const val ICON = "ICON"


class HistorySource(private val contentResolver: ContentResolver) {


    fun insert(entity: HistoryWeatherEntity) {
        contentResolver.insert(HISTORY_URI, toContentValues(entity))
    }

    data class HistoryWeatherEntity(
        val id: Long = 0,
        val cityName: String = "",
        val temperature: Int = 0,
        val feelsLike: Int = 0,
        val icon: String = ""
    )


    val HISTORY_URI =
        Uri.parse("content://com.gb.kotlin_1728_2_1.EducationContentProvider/HistoryWeatherEntity")

    fun toEntity(cursor: Cursor): HistoryWeatherEntity {
        return HistoryWeatherEntity(
            cursor.getLong(cursor.getColumnIndex(ID)),
            cursor.getString(cursor.getColumnIndex(NAME)),
            cursor.getInt(cursor.getColumnIndex(TEMPERATURE))
        )
    }

    private fun toContentValues(entity: HistoryWeatherEntity): ContentValues {
        return ContentValues().apply {
            put(ID, entity.id)
            put(NAME, entity.cityName)
            put(TEMPERATURE, entity.temperature)
        }
    }
}