plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    compileSdk = 34
    namespace = "com.arr.arcprogressbar"

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation("com.google.android.material:material:1.9.0")
	implementation("androidx.appcompat:appcompat:1.7.0")
	implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
}
android {
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.ghxstbyte"
            artifactId = "progress-indicator"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
    repositories {
        maven {
            name = "jitpack"
            url = uri("https://jitpack.io")
        }
    }
}