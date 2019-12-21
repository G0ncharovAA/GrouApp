package ru.gonchar17narod.grouapp.presentation.converters

import ru.gonchar17narod.business.entities.base.BaseEntity
import ru.gonchar17narod.grouapp.presentation.view_objects.EntityVO

object EntitiesVOConverter {

    fun BaseEntity.fromEntity() =
        EntityVO(id = id)
}