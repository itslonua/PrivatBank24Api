package a.com.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class ApiFactory {

    companion object {
        fun <T> create(clazz: Class<T>, apiUrl: String, httpClient: OkHttpClient): T {

            val builder = GsonBuilder()
            builder.registerTypeAdapter(List::class.java, ListDeserializer())

            return Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))

                    .client(httpClient)
                    .build()
                    .create(clazz)
        }
    }

}