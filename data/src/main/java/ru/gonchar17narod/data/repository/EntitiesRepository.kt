package ru.gonchar17narod.data.repository

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import ru.gonchar17narod.business.entities.base.BaseEntity
import ru.gonchar17narod.business.repository.IEntitiesRepository
import ru.gonchar17narod.data.data_transfer_objects.EntityDTO
import ru.gonchar17narod.data.converters.EntitiesDTOConverter.toEntities
import javax.inject.Inject

class EntitiesRepository @Inject constructor(
    val retrofit: Retrofit
) : IEntitiesRepository {

    override fun getEntities(): Observable<List<BaseEntity>> =
        Observable.fromCallable {
            List(10) { EntityDTO(it.toString()) }
        }
            .subscribeOn(Schedulers.io())
            .map {
                it.toEntities()
            }
}