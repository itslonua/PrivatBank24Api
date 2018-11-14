package mobile.privatbank24api.di

import a.com.core.rx.DefaultSchedulersProvider
import a.com.data.network.NetworkModule
import a.com.data.repository.ExchangeDataRepository
import a.com.domain.interactor.ExchangeUseCase

object DependencyFactory {

    fun createSchedulersProvider() = DefaultSchedulersProvider()

    fun searchUseCase(): ExchangeUseCase {
        val api = NetworkModule.provideRetrofitClient()
        val repository = ExchangeDataRepository(api)
        return ExchangeUseCase(repository)
    }

}