plugins {
    java
}

group = "faang.school"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    /**
     * Utils & Logging
     */
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")
    implementation("org.slf4j:slf4j-api:2.0.5")
    implementation("ch.qos.logback:logback-classic:1.4.7")
    /**implementation("org.project-lombok:lombok:1.18.26")**/
    implementation("junit:junit:4.13.2")
    /**annotationProcessor("org.project-lombok:lombok:1.18.26")**/

    /**
     * Tests
     */
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val test by tasks.getting(Test::class) { testLogging.showStandardStreams = true }
