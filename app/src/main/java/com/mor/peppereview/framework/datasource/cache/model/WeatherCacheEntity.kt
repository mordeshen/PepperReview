package com.mor.peppereview.framework.datasource.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mor.peppereview.buisness.domain.models.ListItemDomain


@Entity(tableName = "weather_db")
class WeatherCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "clouds")
    val clouds: Int,

    @ColumnInfo(name = "coord_lat")
    val coord_lat: Double,

    @ColumnInfo(name = "coord_lon")
    val coord_lon: Double,

    @ColumnInfo(name = "dt")
    val dt: Int,

    @ColumnInfo(name = "main_feels_like")
    val main_feels_like: Double,

    @ColumnInfo(name = "main_humidity")
    val main_humidity: Int,

    @ColumnInfo(name = "main_pressure")
    val main_pressure: Int,

    @ColumnInfo(name = "main_temp")
    val main_temp: Double,

    @ColumnInfo(name = "main_temp_max")
    val main_temp_max: Double,

    @ColumnInfo(name = "main_temp_minval")
    val main_temp_minval: Double,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "rain")
    val rain: Any,

    @ColumnInfo(name = "snow")
    val snow: Any,

    @ColumnInfo(name = "sys_country")
    val sys_country: String,

    @ColumnInfo(name = "sys_id")
    val sys_id: Int,

    @ColumnInfo(name = "sys_message")
    val sys_message: Double,

    @ColumnInfo(name = "sys_sunrise")
    val sys_sunrise: Int,

    @ColumnInfo(name = "sys_sunset")
    val sys_sunset: Int,

    @ColumnInfo(name = "sys_type")
    val sys_type: Int,

    @ColumnInfo(name = "listItemDomain")
    val listItemDomain: List<ListItemDomain>,

    @ColumnInfo(name = "wind_deg")
    val wind_deg: Int,

    @ColumnInfo(name = "wind_speed")
    val wind_speed: Int,

    @ColumnInfo(name = "timezone")
    val timezone: Int,

    @ColumnInfo(name = "visibility")
    val visibility: Int

)