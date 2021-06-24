package com.mor.peppereview.framework.datasource.cache.mappers

import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.util.EntityMapper
import com.mor.peppereview.framework.datasource.cache.model.WeatherCacheEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<WeatherCacheEntity, Domain> {

    override fun mapFromEntity(entity: WeatherCacheEntity): Domain {
        return Domain(
            clouds = entity.clouds,
            coord_lat = entity.coord_lat,
            coord_lon = entity.coord_lon,
            dt = entity.dt,
            id = entity.id,
            main_feels_like = entity.main_feels_like,
            main_humidity = entity.main_humidity,
            main_pressure = entity.main_pressure,
            main_temp = entity.main_temp,
            main_temp_max = entity.main_temp_max,
            main_temp_minval = entity.main_temp_minval,
            name = entity.name,
            rain = entity.rain,
            snow = entity.snow,
            sys_country = entity.sys_country,
            listItemDomain = entity.listItemDomain,
            wind_deg = entity.wind_deg,
            wind_speed = entity.wind_speed,
            sys_id = entity.sys_id,
            sys_message = entity.sys_message,
            sys_sunrise = entity.sys_sunrise,
            sys_sunset = entity.sys_sunset,
            sys_type = entity.sys_type,
            timezone = entity.timezone,
            visibility = entity.visibility
        )
    }

    override fun mapToEntity(domainModel: Domain): WeatherCacheEntity {
        return WeatherCacheEntity(
            clouds = domainModel.clouds,
            coord_lat = domainModel.coord_lat,
            coord_lon = domainModel.coord_lon,
            dt = domainModel.dt,
            id = domainModel.id,
            main_feels_like = domainModel.main_feels_like,
            main_humidity = domainModel.main_humidity,
            main_pressure = domainModel.main_pressure,
            main_temp = domainModel.main_temp,
            main_temp_max = domainModel.main_temp_max,
            main_temp_minval = domainModel.main_temp_minval,
            name = domainModel.name,
            rain = domainModel.rain,
            snow = domainModel.snow,
            sys_country = domainModel.sys_country,
            listItemDomain = domainModel.listItemDomain,
            wind_deg = domainModel.wind_deg,
            wind_speed = domainModel.wind_speed,
            sys_id = domainModel.sys_id,
            sys_message = domainModel.sys_message,
            sys_sunrise = domainModel.sys_sunrise,
            sys_sunset = domainModel.sys_sunset,
            sys_type = domainModel.sys_type,
            timezone = domainModel.timezone,
            visibility = domainModel.visibility
        )
    }

    fun mapFromEntityList(entities: List<WeatherCacheEntity>): List<Domain> {
        return entities.map { mapFromEntity(it) }
    }

}