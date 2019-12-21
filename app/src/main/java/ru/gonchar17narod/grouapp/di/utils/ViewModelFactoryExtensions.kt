package ru.gonchar17narod.grouapp.di.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

interface IIdentityProvider {
    fun getIdentity(): String
}

inline fun <reified T : ViewModel> ViewModelProvider.Factory.getUniqueViewModelFor(viewModelStoreOwner: ViewModelStoreOwner, identityProvider: IIdentityProvider): T =
    ViewModelProvider(viewModelStoreOwner.viewModelStore, this)[identityProvider.getIdentity(), T::class.java]

inline fun <reified T : ViewModel> ViewModelProvider.Factory.getViewModelFor(viewModelStoreOwner: ViewModelStoreOwner, key: String? = null): T {
    val viewModelProvider = ViewModelProvider(viewModelStoreOwner.viewModelStore, this)

    return when {
        key != null ->
            viewModelProvider["$key:${T::class.java.canonicalName}", T::class.java]
        else ->
            viewModelProvider[T::class.java]
    }
}

inline fun <reified T : ViewModel> ViewModelProvider.Factory.getViewModelSharedByParentFragment(fragment: Fragment, key: String): T {
    val parentFragment = fragment.parentFragment ?: error("fragment.parentFragment is null")

    return ViewModelProvider(parentFragment, this)["$key:${T::class.java.canonicalName}", T::class.java]
}