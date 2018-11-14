package mobile.privatbank24api.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mobile.privatbank24api.R
import mobile.privatbank24api.utils.observe

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by lazy {
        SplashModule.createViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity_layout)
        viewModel.create()
        observe(viewModel.liveData, ::render)
    }

    private fun render(state: Boolean?) {
        when(state) {
            true ->  SplashNavigator.openMainScreen(this)
        }
    }

}