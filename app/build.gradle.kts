plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.emergetools.android")
}

val sdkVersion = System.getenv("CURRENT_SDK_VERSION") ?: "4.16.2"
val branchName = System.getenv("CURRENT_SDK_BRANCH") ?: "develop"

android {
    namespace = "com.sendbird.sendbirdsdksizechecker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sendbird.chat.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = true
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
            //TODO: Environment variable 로 바꿔서 나중에 다른 곳에서 쓸 수 있게 바꾸기
            apiToken.set("0b574fed-9ce5-4472-9eee-836aaa455c48")
            repoName.set("chat-android")
            repoOwner.set("sendbird")
//            branchName.set(branchName)
        }
    }
}

dependencies {
    //TODO: Environment variable 로 바꿔서 나중에 다른 곳에서 쓸 수 있게 바꾸기
    implementation("com.sendbird.sdk:sendbird-chat-local:$sdkVersion")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}