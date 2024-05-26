plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    testImplementation(libs.testng)

    implementation(libs.lombok)
    implementation(libs.assertj)
    implementation(libs.bundles.restassured)
    implementation(libs.log4j)
    implementation(libs.owner.aeonbits)
    implementation(libs.javax)
    implementation(libs.slf4j)
    annotationProcessor(libs.lombok)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

tasks.named<Test>("test") {
    // Use TestNG for unit tests.
    useTestNG()
}
