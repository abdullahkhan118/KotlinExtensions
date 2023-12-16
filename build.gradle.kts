import org.apache.commons.logging.LogFactory.release


plugins {
    kotlin("jvm") version "1.9.21"
    id("maven-publish")
}

apply {
    plugin("maven-publish")
}

group = "com.github.abdullahkhan118"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["java"])
                groupId = "com.github.abdullahkhan118"
                artifactId = "kotlin.extensions"
                version = "1.0.1"
            }
        }
    }
}