package mobile.privatbank24api.ui.exchange

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class ExchangeAdapter(private var dataSet: List<ExchangeItem> = listOf()) : RecyclerView.Adapter<ExchangeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ExchangeViewHolder.create(inflater, parent)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(viewHolder: ExchangeViewHolder, position: Int) {
        val dataItem = dataSet[position]
        viewHolder.bind(dataItem)
    }

    fun swapData(newItems: List<ExchangeItem>,
                 diffUtilsCallbackProducer: (List<ExchangeItem>, List<ExchangeItem>) -> DiffUtil.Callback) {
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallbackProducer.invoke(dataSet, newItems))
        dataSet = newItems.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

}