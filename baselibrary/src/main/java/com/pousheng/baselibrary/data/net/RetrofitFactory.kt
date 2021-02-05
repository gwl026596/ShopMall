package com.pousheng.baselibrary.data.net

import com.pousheng.baselibrary.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class RetrofitFactory private constructor(){
    companion object{
        val instance:RetrofitFactory by lazy { RetrofitFactory()  }
    }

    val retrofit : Retrofit
    val interceptor:Interceptor
    init {
        interceptor=Interceptor{ chain ->
           val request= chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Charset", "utf-8")
                .build()
            chain.proceed(request)
        }
        retrofit=Retrofit.Builder().
            baseUrl(BuildConfig.API_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    fun initClient():OkHttpClient{
        val  logInterceptor= HttpLoggingInterceptor()
        logInterceptor.level= if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val okHttpClient =OkHttpClient().newBuilder().connectTimeout(9, TimeUnit.SECONDS)
            .addInterceptor(logInterceptor)
            .addInterceptor(interceptor)
            .build()
        ignoreSSLCheck(okHttpClient)
        return okHttpClient
    }

    fun <T> create(clazz: Class<T>):T{
       return retrofit.create(clazz)
    }

    private fun ignoreSSLCheck(okHttpClient: OkHttpClient) {
        var sc: SSLContext? = null
        try {
            sc = SSLContext.getInstance("SSL")
            sc.init(null, arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate>? {
                    return null
                }
            }), SecureRandom())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val hv1 = HostnameVerifier { hostname, session -> true }
        val workerClassName = "okhttp3.OkHttpClient"
        try {
            val workerClass = Class.forName(workerClassName)
            val hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier")
            hostnameVerifier.isAccessible = true
            hostnameVerifier[okHttpClient] = hv1
            val sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory")
            sslSocketFactory.isAccessible = true
            sslSocketFactory[okHttpClient] = sc!!.socketFactory
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}