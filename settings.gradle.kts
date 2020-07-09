rootProject.name = "oauth2"
include("foo")
include("oauthapp")

rootProject.children.forEach { subProject ->
    subProject.buildFileName = "${subProject.name}.gradle.kts"
}
pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
