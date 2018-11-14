package mobile.privatbank24api.ui.splash

import a.com.core.rx.SchedulersProvider
import a.com.core.viewmodel.BaseViewModel
import android.arch.lifecycle.MutableLiveData
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class SplashViewModel(private val schedulers: SchedulersProvider) : BaseViewModel() {

    val liveData = MutableLiveData<Boolean>()

    fun create() {

        bindUntilClear {
            Single.timer(5, TimeUnit.SECONDS, schedulers.ui)
                    .observeOn(schedulers.ui)
                    .map { true }
                    .subscribe(liveData::postValue, Throwable::printStackTrace)
        }

    }

}