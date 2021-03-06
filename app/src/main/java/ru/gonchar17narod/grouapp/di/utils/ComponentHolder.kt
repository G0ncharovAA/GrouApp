package ru.gonchar17narod.grouapp.di.utils

class ComponentHolder<out T>(
    private val constructor: () -> T,
    private val destructor: () -> Unit
) {

    private var component: T? = null

    fun get(): T = component ?: constructor().also { component = it }

    fun destroy() {
        destructor.invoke()
        component = null
    }
}

inline fun <reified T> componentHolder(
    noinline constructor: () -> T,
    noinline destructor: () -> Unit = {}
): ComponentHolder<T> =
    ComponentHolder(constructor, destructor)