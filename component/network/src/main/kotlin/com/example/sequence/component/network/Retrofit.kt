package com.example.sequence.component.network

import org.koin.core.scope.Scope
import retrofit2.Retrofit

fun Scope.getRetrofit(): Retrofit =
	get(Retrofit::class)
