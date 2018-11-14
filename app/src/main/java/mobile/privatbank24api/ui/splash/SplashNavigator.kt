package mobile.privatbank24api.ui.splash

import android.content.Context
import mobile.privatbank24api.ui.exchange.ExchangeActivity
import mobile.privatbank24api.utils.startWithClearTask

object SplashNavigator {

    fun openMainScreen(context: Context) {
        val mainActivityIntent = ExchangeActivity.newIntent(context)
        mainActivityIntent.startWithClearTask(context)
    }

}