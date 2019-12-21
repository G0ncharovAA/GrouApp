package ru.gonchar17narod.grouapp.di.components

import dagger.Subcomponent
import ru.gonchar17narod.business.use_cases.BaseGetEntitiesUseCase
import ru.gonchar17narod.grouapp.di.modules.EntitiesModule
import ru.gonchar17narod.grouapp.di.scopes.ActivityScope

@ActivityScope
@Subcomponent(modules = [EntitiesModule::class])
interface EntitiesComponent {

    fun getEntitiesInteractor(): BaseGetEntitiesUseCase

    @Subcomponent.Builder
    interface Builder {

        fun build(): EntitiesComponent
    }
}