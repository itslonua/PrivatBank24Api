package a.com.data.entity.exchange

import com.google.gson.annotations.SerializedName

data class ExchangeItemResponse(

	@field:SerializedName("sale")
	val sale: String? = null,

	@field:SerializedName("base_ccy")
	val baseCcy: String? = null,

	@field:SerializedName("buy")
	val buy: String? = null,

	@field:SerializedName("ccy")
	val ccy: String? = null
)