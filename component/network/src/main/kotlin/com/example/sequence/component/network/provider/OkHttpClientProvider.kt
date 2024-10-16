package com.example.sequence.component.network.provider

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

private const val VALUE_TIMEOUT: Long = 60

fun provideOkHttpClient(
	interceptors: List<Interceptor> = emptyList(),
): OkHttpClient =
	OkHttpClient()
		.newBuilder()
		.applyDefaultSetups(interceptors)
		.build()

private fun OkHttpClient.Builder.applyDefaultSetups(
	interceptors: List<Interceptor>,
): OkHttpClient.Builder {
	connectTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS)
	writeTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS)
	readTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS)
	retryOnConnectionFailure(true)
	addInterceptor(provideLoggingInterceptor())
	interceptors.forEach { addInterceptor(it) }
	return this
}

private fun provideLoggingInterceptor(): Interceptor =
	HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BODY
	}
