package ru.gonchar17narod.grouapp.presentation.navigation

import android.content.Context
import android.content.Intent
import ru.gonchar17narod.grouapp.presentation.view.activities.HomeActivity
import ru.gonchar17narod.grouapp.presentation.view.activities.ProfileActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    object HomeScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    object ProfileScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }
}