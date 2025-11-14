plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.luck.picture.lib"

    compileSdk = 36

    defaultConfig {
        minSdk = 19

        vectorDrawables.useSupportLibrary = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.recyclerview)
    //implementation "androidx.activity:activity:${cfgs.activity_version}"
    //implementation "androidx.fragment:fragment:${cfgs.fragment_version}"
    implementation(libs.androidx.exifinterface)
    implementation(libs.androidx.viewpager2)
    implementation(libs.androidx.constraintlayout)
}

val VERSION_NAME = "1.0"
val GROUP_ID = "com.github.kanshenmekan"
val ARTIFACT_ID = "selector"

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