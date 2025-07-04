/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.9/samples
 */

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    eclipse
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

java {
    // Configure the Java compilation tasks to use Java 17.
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("com.example.h2.H2Server")
}

dependencies {
    implementation("com.h2database:h2:2.3.232")
}
