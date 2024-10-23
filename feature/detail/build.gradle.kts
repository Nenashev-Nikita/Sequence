plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.jetbrains.kotlin.serialization)
	alias(libs.plugins.google.ksp)
}

android {
	namespace = "com.example.sequence.feature.detail"
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
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.14"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	implementation(project(":design"))
	implementation(project(":component:network"))
	implementation(project(":component:presentation"))
	implementation(project(":shared:movie"))

	implementation(libs.coil.compose)
	
	implementation(libs.cicerone)
	implementation(libs.androidx.fragment.ktx)

	implementation(libs.koin.core)
	implementation(libs.koin.android)

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.lifecycle.viewmodel.compose)

	// Compose
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)

	implementation(libs.retrofit.converter.kotlinxserialization)

	// Unit-тестирование
	testImplementation(libs.junit)
}