package ru.gonchar17narod.grouapp.presentation.view.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.layout_toolbar.*
import ru.gonchar17narod.grouapp.R
import ru.gonchar17narod.grouapp.presentation.view.activities.base.BaseActivity
import ru.gonchar17narod.grouapp.presentation.view.viewmodels.ProfileViewModel

class ProfileActivity : BaseActivity() {

    private val profileViewModel by lazy {

        ViewModelProviders.of(this)[ProfileViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(root_toolbar);
    }
}
