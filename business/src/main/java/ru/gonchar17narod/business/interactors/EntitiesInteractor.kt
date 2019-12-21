package ru.gonchar17narod.business.interactors

import io.reactivex.Observable
import ru.gonchar17narod.business.entities.base.BaseEntity
import ru.gonchar17narod.business.repository.IEntitiesRepository
import ru.gonchar17narod.business.use_cases.BaseGetEntitiesUseCase
import javax.inject.Inject

class EntitiesInteractor @Inject constructor(
    val entitiesRepository: IEntitiesRepository
) : BaseGetEntitiesUseCase {

    override fun getEntities(): Observable<List<BaseEntity>> =
        entitiesRepository.getEntities()
}