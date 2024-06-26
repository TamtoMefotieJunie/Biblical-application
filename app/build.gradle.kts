


plugins {
    alias(libs.plugins.androidApplication)

}

android {
    namespace = "com.example.biblicalapp"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.biblicalapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}


dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
//    implementation ("com.android.volley:volley:1.1.1")
//    implementation ("com.android.support:design:28.0.0")
//    implementation ("com.rengwuxian.materialedittext:library:2.1.4")
//    androidTestImplementation("androidx.test:runner:1.2.0")
////    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation ("com.android.volley:volley:1.2.1")



}
