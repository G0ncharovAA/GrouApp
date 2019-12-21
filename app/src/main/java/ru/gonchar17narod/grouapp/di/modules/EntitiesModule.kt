package ru.gonchar17narod.grouapp.di.modules

import dagger.Binds
import dagger.Module
import ru.gonchar17narod.business.interactors.EntitiesInteractor
import ru.gonchar17narod.business.repository.IEntitiesRepository
import ru.gonchar17narod.business.use_cases.BaseGetEntitiesUseCase
import ru.gonchar17narod.data.repository.EntitiesRepository
import ru.gonchar17narod.grouapp.di.scopes.ActivityScope

@Module
abstract class EntitiesModule {

    @ActivityScope
    @Binds
    abstract fun bindEntitiesUseCase(entitiesInteractor: EntitiesInteractor): BaseGetEntitiesUseCase

    @ActivityScope
    @Binds
    abstract fun bindEntitiesRepository(entitiesRepository: EntitiesRepository): IEntitiesRepository
}