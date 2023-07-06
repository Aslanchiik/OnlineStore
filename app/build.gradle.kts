plugins {
    id(Plugins.AGP.application)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)

    // Hilt
    id(Plugins.Hilt.android)
}

android {
    namespace = "com.example.onlinestore"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.onlinestore"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = Options.compileOptions
        targetCompatibility = Options.compileOptions
    }
    kotlinOptions {
        jvmTarget = Options.kotlinOptions
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    // Kotlin
    implementation(Libraries.Coroutines.android)

    // UI Components
    implementation(Libraries.UIComponents.material)
    implementation(Libraries.UIComponents.constraintLayout)
    implementation(Libraries.Core.core)
    implementation(Libraries.UIComponents.vbpd)

    // Activity
    implementation(Libraries.Activity.activity)

    // Fragment
    implementation(Libraries.Fragment.fragment)

    // Lifecycle
    implementation(Libraries.Lifecycle.viewModel)
    implementation(Libraries.Lifecycle.runtime)

    // Navigation
    implementation(Libraries.Navigation.fragment)
    implementation(Libraries.Navigation.ui)

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)
    implementation(Libraries.Hilt.navigation)

    // Glide
    implementation(Libraries.UIComponents.glide)

    // CircleImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")
}