package mobile.privatbank24api.ui.exchange

import android.support.v7.util.DiffUtil

class ExchangeDiffUtils(private val oldData: List<ExchangeItem>,
                        private val newData: List<ExchangeItem>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldData.size

    override fun getNewListSize() = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]
        return oldItem.sale == newItem.sale
                && oldItem.buy == newItem.buy
                && oldItem.baseCurrency == newItem.baseCurrency
                && oldItem.currencyCode == newItem.currencyCode
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldData[oldItemPosition] == newData[newItemPosition]
}
