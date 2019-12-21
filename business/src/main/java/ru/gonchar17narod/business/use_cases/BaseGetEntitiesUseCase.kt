package ru.gonchar17narod.business.use_cases

import io.reactivex.Observable
import ru.gonchar17narod.business.entities.base.BaseEntity

interface BaseGetEntitiesUseCase {

    fun getEntities(): Observable<List<BaseEntity>>
}