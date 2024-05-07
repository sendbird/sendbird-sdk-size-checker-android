plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.emergetools.android")
}

android {
    namespace = "com.sendbird.sendbirdsdksizechecker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sendbird.sendbirdsdksizechecker"
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

emerge {
    vcs {
        sha.set("d1716f12cb9cda95850e88c4a6a51b5cde7a70bd")
        baseSha.set("8ede7e53eeaa954d1c945c288004134b5ae83118")
        branchName.set("feature/teddy/emerge-test")
        prNumber.set("1584")

        gitHub {
            repoName.set("chat-android")
            repoOwner.set("sendbird")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}