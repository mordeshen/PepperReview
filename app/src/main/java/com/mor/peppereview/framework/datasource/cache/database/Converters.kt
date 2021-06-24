package com.mor.peppereview.framework.datasource.cache.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mor.peppereview.buisness.domain.models.ListItemDomain

class Converters {

    @TypeConverter
    fun listToJson(value: List<ListItemDomain>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<ListItemDomain>::class.java).toList()
}