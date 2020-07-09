plugins {
    id("org.siouan.frontend")
}

frontend {
    nodeVersion.set("14.4.0")
    assembleScript.set("run build")
    cleanScript.set("run clean")
    checkScript.set("run check")
    packageJsonDirectory.set(file("src/main/resources"))
}

