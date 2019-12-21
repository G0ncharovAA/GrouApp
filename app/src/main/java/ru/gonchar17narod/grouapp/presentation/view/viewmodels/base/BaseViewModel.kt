package ru.gonchar17narod.grouapp.presentation.view.viewmodels.base

import androidx.lifecycle.ViewModel
import ru.gonchar17narod.grouapp.presentation.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

open class BaseViewModel @Inject constructor(
    protected val router: Router
) : ViewModel() {

    fun navigateToHome() =
        router.navigateTo(Screens.HomeScreen)

    fun navigateToProfile() =
        router.navigateTo(Screens.ProfileScreen)
}