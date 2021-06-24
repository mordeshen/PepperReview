package com.mor.peppereview.buisness.domain.models

data class Domain(

    val clouds: Int,
    val coord_lat: Double,
    val coord_lon: Double,
    val dt: Int,
    val id: Int,
    val main_feels_like: Double,
    val main_humidity: Int,
    val main_pressure: Int,
    val main_temp: Double,
    val main_temp_max: Double,
    val main_temp_minval: Double,
    val name: String,
    val rain: Any,
    val snow: Any,
    val sys_country: String,
    val sys_id: Int,
    val sys_message: Double,
    val sys_sunrise: Int,
    val sys_sunset: Int,
    val sys_type: Int,
    val listItemDomain: List<ListItemDomain>,
    val wind_deg: Int,
    val wind_speed: Int,
    val timezone: Int,
    val visibility: Int
)