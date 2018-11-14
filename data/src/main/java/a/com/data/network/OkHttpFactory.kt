package a.com.data.network


import a.com.data.BuildConfig
import okhttp3.OkHttpClient
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

internal class OkHttpFactory(private val interceptorFactory: InterceptorFactory) {

    companion object {
        val trustAllCerts by lazy {
            arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }

                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }
            })
        }

    }

    fun buildOkHttpClient(): OkHttpClient.Builder {
        return with(OkHttpClient().newBuilder()) {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)

            addInterceptor(interceptorFactory.responseInterceptor())
            addInterceptor(interceptorFactory.loggingInterceptor())

            if (BuildConfig.DEBUG) {
                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, java.security.SecureRandom())
                val sslSocketFactory = sslContext.socketFactory
                sslSocketFactory(sslSocketFactory)
                retryOnConnectionFailure(false)

            }
            hostnameVerifier { _, _ -> true }
        }
    }

}