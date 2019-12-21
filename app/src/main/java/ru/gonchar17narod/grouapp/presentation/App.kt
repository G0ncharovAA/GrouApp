package ru.gonchar17narod.grouapp.presentation

import android.app.Application
import ru.gonchar17narod.grouapp.BuildConfig
import ru.gonchar17narod.grouapp.di.DI
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        DI.init(this)
    }
}