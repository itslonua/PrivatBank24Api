package a.com.core.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultSchedulersProvider : SchedulersProvider {

    override val io: Scheduler = Schedulers.io()

    override val ui: Scheduler = AndroidSchedulers.mainThread()

    override val computation: Scheduler = Schedulers.computation()
}