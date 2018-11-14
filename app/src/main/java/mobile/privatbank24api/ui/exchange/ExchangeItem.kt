package mobile.privatbank24api.ui.exchange

data class ExchangeItem(val currencyCode: String,
                        val baseCurrency: String,
                        val buy: String,
                        val sale: String)