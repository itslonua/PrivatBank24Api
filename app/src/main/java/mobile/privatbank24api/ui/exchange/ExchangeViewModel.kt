package mobile.privatbank24api.ui.exchange

import a.com.core.rx.SchedulersProvider
import a.com.core.viewmodel.BaseViewModel
import a.com.domain.interactor.ExchangeUseCase
import a.com.domain.model.exchange.ExchangeItemResult
import android.arch.lifecycle.MutableLiveData
import mobile.privatbank24api.utils.ResultViewState

class ExchangeViewModel(private val schedulers: SchedulersProvider,
                        private val searchUseCase: ExchangeUseCase) : BaseViewModel() {

    val liveData =  MutableLiveData<ResultViewState>()

    fun create() {
        bindUntilClear {
            searchUseCase.getExchangeRates()
                    .map(::mapToExchangeItem)
                    .doOnSubscribe { liveData.postValue(ResultViewState.InFlight) }
                    .doOnSuccess { liveData.postValue(ResultViewState.Success(it)) }
                    .doOnError { liveData.postValue(ResultViewState.Error(it)) }
                    .subscribeOn(schedulers.computation)
                    .observeOn(schedulers.ui)
                    .subscribe()
        }
    }

    private fun mapToExchangeItem(result: List<ExchangeItemResult>): List<ExchangeItem> {
        return result.map {
            ExchangeItem(it.ccy ?: "",
                    it.baseCcy ?: "",
                    it.buy ?: "",
                    it.sale ?: "") }
    }

}