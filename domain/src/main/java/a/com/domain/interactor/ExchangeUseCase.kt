package a.com.domain.interactor

import a.com.domain.model.exchange.ExchangeItemResult
import a.com.domain.repository.ExchangeRepository
import io.reactivex.Single

class ExchangeUseCase(private val repository: ExchangeRepository) {

    fun getExchangeRates(): Single<List<ExchangeItemResult>> =
            repository.getExchangeRates()
}