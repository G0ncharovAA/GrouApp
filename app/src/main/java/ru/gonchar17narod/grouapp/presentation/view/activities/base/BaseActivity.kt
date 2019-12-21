package ru.gonchar17narod.grouapp.presentation.view.activities.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.gonchar17narod.grouapp.R
import ru.gonchar17narod.grouapp.di.DI
import ru.gonchar17narod.grouapp.di.utils.ViewModelFactory
import ru.gonchar17narod.grouapp.di.utils.getViewModelFor
import ru.gonchar17narod.grouapp.presentation.view.viewmodels.base.BaseViewModel
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    private lateinit var baseViewModel: BaseViewModel

    private val navigator = SupportAppNavigator(this, R.id.root_layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.appComponenet.inject(this)
        baseViewModel = viewModelFactory.getViewModelFor(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_root_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_home -> {
                baseViewModel.navigateToHome()
            }
            R.id.menu_item_profile -> {
                baseViewModel.navigateToProfile()
            }
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}