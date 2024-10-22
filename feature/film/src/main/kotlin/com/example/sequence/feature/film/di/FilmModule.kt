package com.example.sequence.feature.film.di

import com.example.sequence.component.network.createRetrofitService
import com.example.sequence.component.network.getRetrofit
import com.example.sequence.feature.film.data.converter.FilmConverter
import com.example.sequence.feature.film.data.network.FilmApi
import com.example.sequence.feature.film.data.repository.FilmRepositoryImpl
import com.example.sequence.feature.film.domain.repository.FilmRepository
import com.example.sequence.feature.film.domain.usecase.FilterFilmsByGenresUseCase
import com.example.sequence.feature.film.domain.usecase.GetAllFilmsUseCase
import com.example.sequence.feature.film.presentation.FilmViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val filmModel = module {
	factory { createRetrofitService<FilmApi>(getRetrofit()) }

	factory { FilmConverter() }

	factory<FilmRepository> {
		FilmRepositoryImpl(
			api = get(),
			filmConverter = get(),
		)
	}

	factory { GetAllFilmsUseCase(get()) }
	factory { FilterFilmsByGenresUseCase(get()) }

	viewModel {
		FilmViewModel(
			getAllFilmsUseCase = get(),
			filterFilmsByGenresUseCase = get(),
			router = get(),
		)
	}
}