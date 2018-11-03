name := "scalajs-cross-compile-tarjan"

scalaVersion in ThisBuild := "2.12.4"

lazy val root = project.in(file(".")).
  aggregate(tarjanJS, tarjanJVM).
  settings(
    publish := {},
    publishLocal := {},
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )

lazy val tarjan = crossProject.in(file(".")).
  settings(
    name := "scala-tarjan",
    version := "0.1-SNAPSHOT",
    organization := "com.github.fbaierl"
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val tarjanJVM = tarjan.jvm
lazy val tarjanJS = tarjan.js


// Publishing

useGpg := true

ThisBuild / organization := "com.github.fbaierl"
ThisBuild / organizationName := "fbaierl"
ThisBuild / organizationHomepage := Some(url("https://github.com/fbaierl"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/fbaierl/scalajs-cross-compile-tarjan"),
    "scm:git@github.com:fbaierl/scalajs-cross-compile-tarjan.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "fbaierl",
    name  = "Florian Baierl",
    email = "fbaierl1@gmail.com",
    url   = url("https://github.com/fbaierl")
  )
)

ThisBuild / description := "Scala JVM & Scala.js implementation of Tarjan's strongly connected components algorithm."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/example/project"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
