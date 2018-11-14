package mobile.privatbank24api.ui.exchange

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.search_view_holder_layout.view.*
import mobile.privatbank24api.R

class ExchangeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun create(inflater: LayoutInflater,
                   parent: ViewGroup): ExchangeViewHolder {

            return ExchangeViewHolder(inflater.inflate(R.layout.search_view_holder_layout, parent, false))
        }
    }

    fun bind(searchItem: ExchangeItem) {
        with(view) {
            exchange_base_currency.text = searchItem.baseCurrency
            exchange_target_currency.text = searchItem.currencyCode
            exchange_buy.text = searchItem.buy
            exchange_sale.text = searchItem.sale
        }
    }

}