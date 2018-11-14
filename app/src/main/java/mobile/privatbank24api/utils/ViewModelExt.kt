package mobile.privatbank24api.utils

import android.arch.lifecycle.*
import android.support.v4.app.FragmentActivity

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

