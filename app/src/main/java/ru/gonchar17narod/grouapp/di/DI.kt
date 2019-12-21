package ru.gonchar17narod.grouapp.di

import android.content.Context
import ru.gonchar17narod.grouapp.di.components.*
import ru.gonchar17narod.grouapp.di.utils.componentHolder

object DI {

    lateinit var appComponenet: AppComponent

    val entitiesComponent = componentHolder(
    constructor = { appComponenet.entitiesComponent().build() }
    )

    fun init(context: Context) {
        appComponenet = DaggerAppComponent
            .builder()
            .context(context)
            .build()
    }
}