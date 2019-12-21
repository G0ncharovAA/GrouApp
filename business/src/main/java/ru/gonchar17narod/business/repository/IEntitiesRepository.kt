package ru.gonchar17narod.business.repository

import io.reactivex.Observable
import ru.gonchar17narod.business.entities.base.BaseEntity

interface IEntitiesRepository {

    fun getEntities(): Observable<List<BaseEntity>>
}