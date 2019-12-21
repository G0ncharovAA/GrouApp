package ru.gonchar17narod.data.converters

import ru.gonchar17narod.business.entities.base.BaseEntity
import ru.gonchar17narod.data.data_transfer_objects.EntityDTO

object EntitiesDTOConverter {

    fun EntityDTO.toEntity() =
        BaseEntity(id = id)

    fun List<EntityDTO>.toEntities() =
        map { it.toEntity() }
}