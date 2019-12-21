package ru.gonchar17narod.grouapp.presentation.view.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import ru.gonchar17narod.grouapp.R
import ru.gonchar17narod.grouapp.presentation.items.category.ItemCategory
import ru.gonchar17narod.grouapp.presentation.view.activities.base.BaseActivity
import ru.gonchar17narod.grouapp.presentation.view.viewmodels.HomeViewModel
import ru.gonchar17narod.grouapp.presentation.view_objects.EntityVO
import timber.log.Timber

class HomeActivity : BaseActivity() {

    private val homeViewModel by lazy {

        ViewModelProviders.of(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(root_toolbar)

        root_view_pager.adapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(List(3)  { ItemCategory() } )
        }

        TabLayoutMediator(root_tab_layout, root_view_pager) { tab, position ->
            tab.text = "CAT ${(position + 1)}"
        }.attach()

        homeViewModel.getEntities()
        homeViewModel.liveEntites.observe(this, object : Observer<MutableList<EntityVO>> {
            override fun onChanged(t: MutableList<EntityVO>?) {
                Timber.i("GRP: ".plus(t.toString()))
            }
        })
    }
}
