plugins {
  id("java")
  application
}

group = "io.github.urban233"
version = "1.0"

repositories {
  mavenCentral()
}

application {
  applicationDefaultJvmArgs = listOf(
    "-Djava.library.path=${layout.projectDirectory.dir("bin").asFile.absolutePath}"
  )
  mainClass.set("io.github.urban233.Main")
}

dependencies {
  implementation(files("libs/org.RDKit.jar"))
  testImplementation(platform("org.junit:junit-bom:5.10.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
}