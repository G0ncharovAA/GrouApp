package ru.gonchar17narod.grouapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gonchar17narod.grouapp.di.scopes.ActivityScope
import ru.gonchar17narod.grouapp.di.scopes.ViewModelKey
import ru.gonchar17narod.grouapp.di.utils.ViewModelFactory
import ru.gonchar17narod.grouapp.presentation.view.viewmodels.base.BaseViewModel
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    abstract fun bindBaseViewModel(baseViewModel: BaseViewModel) : ViewModel
}