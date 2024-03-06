plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinxParcelize)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.githubapp"
    compileSdk = 34

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    defaultConfig {
        applicationId = "com.example.githubapp"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.dagger.hilt)
    implementation(libs.androidx.junit.ktx)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.picasso)
    implementation(libs.gson)
    implementation(libs.rxandroid)
    implementation(libs.rxjava)
    testImplementation(libs.mockito)
    testImplementation(libs.core.testing)
    testImplementation(libs.mockk.android)
    implementation(libs.retrofit)
    implementation(libs.lifecycleViewModelKtx)
    implementation(libs.activityktx)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.adapter.rxjava)
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
    androidTestImplementation(libs.androidx.espresso.core)

}