plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.luck.lib.camerax"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    api (libs.androidx.camera.core)
    api (libs.androidx.camera.camera2)
    implementation (libs.androidx.camera.view)
    implementation (libs.androidx.camera.lifecycle)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.transition)
    implementation (libs.androidx.concurrent.futures)
}

val VERSION_NAME = "1.0"
val GROUP_ID = "com.github.kanshenmekan"
val ARTIFACT_ID = "camerax"

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = GROUP_ID
                artifactId = ARTIFACT_ID
                version = VERSION_NAME
                from(components["release"])
            }
        }
    }
}
