package a.com.data.network

import a.com.data.entity.exchange.ExchangeItemResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/p24api/pubinfo?json&exchange&coursid=5")
    fun getExchangeRates(): Single<List<ExchangeItemResponse>>

}