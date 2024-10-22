package com.example.sequence.feature.detail.di

import com.example.sequence.feature.detail.presentation.DetailViewModel
import org.koin.dsl.module

val detailModel = module {
	factory {
		DetailViewModel(
			router = get(),
		)
	}
}