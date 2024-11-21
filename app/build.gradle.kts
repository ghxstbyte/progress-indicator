
plugins {
    id("com.android.application")
    
}

android {
    namespace = "com.example.arcprogressbar"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "com.example.arcprogressbar"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        
    }
    
}

dependencies {


    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    implementation("com.google.android.material:material:1.13.0-alpha06")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation(project(":library"))
}
