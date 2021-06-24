package com.mor.peppereview.framework.datasource.network.mappers

import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.util.EntityMapper
import com.mor.peppereview.framework.datasource.network.model.*
import javax.inject.Inject

class NetworkMapper
@Inject constructor() : EntityMapper<WeatherNetworkEntity, Domain> {
    override fun mapFromEntity(entity: WeatherNetworkEntity): Domain {
        return Domain(
            clouds = entity.clouds.all,
            coord_lat = entity.coord.lat,
            coord_lon = entity.coord.lon,
            dt = entity.dt,
            id = entity.id,
            main_feels_like = entity.main.feels_like,
            main_humidity = entity.main.humidity,
            main_pressure = entity.main.pressure,
            main_temp = entity.main.temp,
            main_temp_max = entity.main.temp_max,
            main_temp_minval = entity.main.temp_min,
            name = entity.name,
            sys_country = entity.sys.country,
            listItemDomain = entity.listItem,
            wind_deg = entity.wind.deg,
            wind_speed = entity.wind.speed.toInt(),
            rain = "",
            snow = "",
            sys_id = entity.sys.id,
            sys_message = entity.sys.message,
            sys_sunrise = entity.sys.sunrise,
            sys_sunset = entity.sys.sunset,
            sys_type = entity.sys.type,
            timezone = entity.timezone,
            visibility = entity.visibility
        )
    }

    override fun mapToEntity(dm: Domain): WeatherNetworkEntity {
        return WeatherNetworkEntity(
            base = "Station",
            clouds = Clouds(dm.clouds),
            cod = 200,
            coord = Coord(dm.coord_lat, dm.coord_lon),
            dt = dm.dt,
            id = dm.id,
            main = Main(
                dm.main_feels_like,
                dm.main_humidity,
                dm.main_pressure,
                dm.main_temp,
                dm.main_temp_max,
                dm.main_temp_minval
            ),
            name = dm.name,
            sys = Sys(
                dm.sys_country,
                dm.id,
                dm.sys_message,
                dm.sys_sunrise,
                dm.sys_sunset,
                dm.sys_type
            ),
            timezone = dm.timezone,
            visibility = dm.visibility,
            listItem = dm.listItemDomain,
            wind = Wind(dm.wind_deg, dm.wind_speed.toDouble())

        )
    }

    fun mapFromEntityList(entities: List<WeatherNetworkEntity>): List<Domain> {
        return entities.map { mapFromEntity(it) }
    }

}
