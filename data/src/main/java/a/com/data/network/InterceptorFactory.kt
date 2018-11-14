package a.com.data.network


import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal class InterceptorFactory {

    fun loggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    fun responseInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder().build()

            val response = try {
                chain.proceed(request)
            } catch (e: Exception) {
                throw NetworkException()
            }

            return@Interceptor response
        }
    }

}
