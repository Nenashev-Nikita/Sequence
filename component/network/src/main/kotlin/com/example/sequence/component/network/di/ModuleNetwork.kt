package com.example.sequence.component.network.di

import com.example.sequence.component.network.provideMoshi
import com.example.sequence.component.network.provider.provideOkHttpClient
import com.example.sequence.component.network.provider.provideRetrofit
import org.koin.dsl.module

const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/sequeniatesttask/"

val networkModule = module {
	single { provideMoshi() }

	single {
		provideOkHttpClient(
			interceptors = listOf()
		)
	}

	single {
		provideRetrofit(
			okHttpClient = get(),
			moshi = get(),
			url = BASE_URL
		)
	}
}