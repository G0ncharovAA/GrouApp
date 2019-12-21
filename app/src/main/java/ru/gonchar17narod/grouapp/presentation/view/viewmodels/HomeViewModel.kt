package ru.gonchar17narod.grouapp.presentation.view.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.gonchar17narod.business.use_cases.BaseGetEntitiesUseCase
import ru.gonchar17narod.grouapp.di.DI
import ru.gonchar17narod.grouapp.presentation.converters.EntitiesVOConverter.fromEntity
import ru.gonchar17narod.grouapp.presentation.view_objects.EntityVO

class HomeViewModel : ViewModel() {

    val liveEntites = MutableLiveData<MutableList<EntityVO>>()
        .apply {
            value = mutableListOf()
        }

    private val entitiesInteractor: BaseGetEntitiesUseCase by lazy {
        DI.entitiesComponent.get().getEntitiesInteractor()
    }

    fun getEntities() =
        entitiesInteractor.getEntities()
            .flatMap {
                Observable.fromIterable(it)
            }
            .map {
                it.fromEntity()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onEntityRecieved
            )

    private fun onEntityRecieved(entityVO: EntityVO) {
        with(liveEntites) {
            postValue(
                value?.apply {
                    add(entityVO)
                }
            )
        }
    }

}