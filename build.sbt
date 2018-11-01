name := "scalajs-cross-compile-tarjan"

scalaVersion in ThisBuild := "2.12.4"

lazy val root = project.in(file(".")).
  aggregate(tarjanJS, tarjanJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val tarjan = crossProject.in(file(".")).
  settings(
    name := "scala-tarjan",
    version := "0.1-SNAPSHOT",
    organization := "com.github.fbaierl"
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val tarjanJVM = tarjan.jvm
lazy val tarjanJS = tarjan.js
