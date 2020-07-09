allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    group = "com.kaushikam.oauth2"
    version = "0.0.1.SNAPSHOT"

}

plugins {
    base
    kotlin("jvm") version "1.3.72" apply false
    kotlin("plugin.spring") version "1.3.72" apply false
    kotlin("plugin.jpa") version "1.3.72" apply false
    kotlin("plugin.allopen") version "1.3.72" apply false
    kotlin("plugin.noarg") version "1.3.72" apply false
    id("org.springframework.boot") version "2.2.0.RELEASE" apply false
    id("org.siouan.frontend") version "3.0.0" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}


configure(subprojects.filter { it.name != "oauthapp" }) {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("io.spring.dependency-management")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencies {
        val compile by configurations
        val implementation by configurations
        val testImplementation by configurations
        val annotationProcessor by configurations
        val testRuntimeOnly by configurations

        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))

        // Logging
        implementation("ch.qos.logback:logback-classic")
        implementation("org.codehaus.groovy:groovy:3.0.3")
        implementation("io.github.microutils:kotlin-logging:1.6.25")
    }
}




