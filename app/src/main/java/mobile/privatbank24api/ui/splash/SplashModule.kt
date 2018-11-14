package mobile.privatbank24api.ui.splash

import mobile.privatbank24api.di.DependencyFactory

object SplashModule {

    fun createViewModel(): SplashViewModel {
        val schedulers = DependencyFactory.createSchedulersProvider()
        return SplashViewModel(schedulers = schedulers)
    }

}