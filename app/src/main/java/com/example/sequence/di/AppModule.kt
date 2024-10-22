package com.example.sequence.di

import com.example.sequence.feature.detail.presentation.DetailRouter
import com.example.sequence.feature.film.presentation.FilmRouter
import com.example.sequence.navigation.buildCicerone
import com.example.sequence.navigation.router.DetailRouterImpl
import com.example.sequence.navigation.router.FilmRouterImpl
import com.example.sequence.navigation.router.MainRouterImpl
import com.example.sequence.presentation.MainRouter
import com.example.sequence.presentation.MainViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

val appModule = module {
	single { buildCicerone() }
	single { get<Cicerone<Router>>().router }
	single { get<Cicerone<Router>>().getNavigatorHolder() }

	factory<FilmRouter> {
		FilmRouterImpl(get())
	}

	factory<DetailRouter> {
		DetailRouterImpl(get())
	}

	factory<MainRouter> {
		MainRouterImpl(get())
	}

	factory {
		MainViewModel(get())
	}
}