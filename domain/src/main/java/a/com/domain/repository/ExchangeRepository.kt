package a.com.domain.repository

import a.com.domain.model.exchange.ExchangeItemResult
import io.reactivex.Single

interface ExchangeRepository {

    fun getExchangeRates(): Single<List<ExchangeItemResult>>

}