package mobile.privatbank24api

import a.com.core.BaseApplication
import android.util.Log
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins

class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        initRxJava()
    }

    private fun initRxJava() {
        RxJavaPlugins.setErrorHandler {
            if (it is UndeliverableException) {
                Log.d("RxJavaPlugins", "on UndeliverableException + ${it.message}")
                return@setErrorHandler
            }
            Thread.currentThread().uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), it)
        }
    }
}