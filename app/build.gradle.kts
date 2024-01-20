plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.agribyte.hackathon"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.agribyte.hackathon"
        minSdk = 24
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.airbnb.android:lottie:3.6.1")

// Add the dependency for the Realtime Database library
// When using the BoM, you don't specify versions in Firebase library dependencies

    implementation("com.google.firebase:firebase-auth:22.2.0")
    implementation ("com.google.android.gms:play-services-maps:17.0.1")
    implementation("com.google.firebase:firebase-database")
    implementation(platform("com.google.firebase:firebase-bom:32.4.0"))
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}