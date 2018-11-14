package mobile.privatbank24api.ui.exchange

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.exchange_activity_layout.*
import mobile.privatbank24api.R
import mobile.privatbank24api.utils.ResultViewState
import mobile.privatbank24api.utils.observe

class ExchangeActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ExchangeActivity::class.java)
    }

    private val viewModel: ExchangeViewModel by lazy {
        ExchangeModule.createViewModel()
    }

    private val exchangeAdapter: ExchangeAdapter by lazy {
        ExchangeAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exchange_activity_layout)
        viewModel.create()

        observe(viewModel.liveData) { data ->

            when(data) {
                is ResultViewState.InFlight -> {
                    search_activity_progress_container.visibility = View.VISIBLE
                }

                is ResultViewState.Success<*> -> {
                    search_activity_progress_container.visibility = View.GONE

                    val newData = data.result as List<ExchangeItem>
                    exchangeAdapter.swapData(newData) { old, new -> ExchangeDiffUtils(old, new) }
                }

                is ResultViewState.Error -> {
                    search_activity_progress_container.visibility = View.GONE
                    Toast.makeText(this, R.string.error_network_message, Toast.LENGTH_SHORT).show()
                }
            }

        }

        with(search_activity_layout_recycler_view) {
            adapter = exchangeAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            val decorationSpacing = resources.getDimension(R.dimen.exchange_item_spacing).toInt()
            addItemDecoration(ExchangeItemDecorator(decorationSpacing))
        }

    }
}
