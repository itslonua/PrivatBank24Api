package a.com.data.network

import a.com.data.BuildConfig
import okhttp3.OkHttpClient

object NetworkModule {

    fun provideRetrofitClient() = ApiFactory.create(Api::class.java,
            BuildConfig.BASE_ENDPOINT,
            provideOkHttpClient())

    private fun provideOkHttpClient(): OkHttpClient {
        val interceptorFactory = InterceptorFactory()
        return OkHttpFactory(interceptorFactory).buildOkHttpClient().build()
    }

}
