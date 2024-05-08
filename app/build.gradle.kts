plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.emergetools.android")
}

val sdkVersion = System.getenv("CURRENT_SDK_VERSION") ?: "4.16.2"
val useSdk = System.getenv("USE_SDK")?.toBoolean() ?: false

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
        gitHub {
            //TODO: Enviroment variable 로 바꿔서 나중에 다른 곳에서 쓸 수 있게 바꾸기
            repoName.set("chat-android")
            repoOwner.set("sendbird")

        }
    }
}

dependencies {
    //TODO: Enviroment variable 로 바꿔서 나중에 다른 곳에서 쓸 수 있게 바꾸기

    if (useSdk) {
        implementation("com.sendbird.sdk:sendbird-chat-local:$sdkVersion")
    }

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}