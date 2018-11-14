package a.com.data.repository

import a.com.data.network.Api
import a.com.domain.model.exchange.ExchangeItemResult
import a.com.domain.repository.ExchangeRepository
import io.reactivex.Single

class ExchangeDataRepository(private val api: Api) : ExchangeRepository {

    override fun getExchangeRates(): Single<List<ExchangeItemResult>> {
       return api.getExchangeRates().map { response ->
           response.map { ExchangeItemResult(it.sale, it.baseCcy, it.buy, it.ccy) }
       }
    }

}