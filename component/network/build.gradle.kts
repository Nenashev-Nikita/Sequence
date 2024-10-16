plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.google.ksp)
}

android {
	namespace = "com.example.sequence.component.network"
	compileSdk = 34

	defaultConfig {
		minSdk = 26

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.koin.core)
	implementation(libs.koin.android)

	implementation(libs.retrofit.moshi)
	implementation(libs.retrofit.moshi.kotlin)
	implementation(libs.retrofit.moshi.adapters)
	implementation(libs.retrofit.converter.moshi)
	implementation(libs.retrofit.converter.scalars)

	implementation(libs.retrofit.core)
	implementation(libs.retrofit.converter.kotlinxserialization)
	implementation(libs.okhttp.logginginterceptor)

	implementation(libs.kotlinx.serialization.json)

	// Unit-тестирование
	testImplementation(libs.junit)
}