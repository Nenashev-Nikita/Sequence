package com.example.sequence.network.di

import org.koin.dsl.module
import com.example.sequence.network.provideMoshi

val moshiModule = module {
	single { provideMoshi() }
}