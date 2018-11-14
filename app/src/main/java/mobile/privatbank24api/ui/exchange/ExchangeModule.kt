package mobile.privatbank24api.ui.exchange

import mobile.privatbank24api.di.DependencyFactory

object ExchangeModule {

    fun createViewModel(): ExchangeViewModel {
        val schedulers = DependencyFactory.createSchedulersProvider()
        val searchUseCase = DependencyFactory.searchUseCase()
        return ExchangeViewModel(schedulers = schedulers,
                searchUseCase = searchUseCase)
    }

}