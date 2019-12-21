package ru.gonchar17narod.grouapp.di.components

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import dagger.Component
import ru.gonchar17narod.grouapp.di.modules.ApiModule
import ru.gonchar17narod.grouapp.di.modules.EntitiesModule
import ru.gonchar17narod.grouapp.di.modules.NavigationModule
import ru.gonchar17narod.grouapp.di.modules.ViewModelModule
import ru.gonchar17narod.grouapp.presentation.view.activities.base.BaseActivity
import ru.gonchar17narod.grouapp.presentation.view.viewmodels.base.BaseViewModel
import javax.inject.Singleton

@Singleton
@Component
    (
    modules = [
        ApiModule::class,
        ViewModelModule::class,
        NavigationModule::class
    ]
)
interface AppComponent {

    fun entitiesComponent(): EntitiesComponent.Builder

    fun inject(baseActivity: BaseActivity)

    fun inject(baseViewModel: BaseViewModel)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(appContext: Context): Builder

        fun build(): AppComponent
    }
}