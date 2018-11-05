import sbt.Keys.libraryDependencies

name := "scalajs-cross-compile-tarjan"

scalaVersion in ThisBuild := "2.12.4"

lazy val root = project.in(file(".")).
  aggregate(tarjanJS, tarjanJVM).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val tarjan = crossProject.in(file(".")).
  settings(
    name := "scala-tarjan",
    version := "0.1.2",
    organization := "com.github.fbaierl",
    scalaVersion := "2.12.4",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test",
    normalizedName := "scala-tarjan",
    crossScalaVersions := Seq("2.10.6", "2.11.11, 2.12.2"),
    homepage := Some(url("https://github.com/fbaierl/scalajs-cross-compile-tarjan")),
    licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php")),
    scmInfo := Some(ScmInfo(
      url("https://github.com/fbaierl/scalajs-cross-compile-tarjan"),
      "scm:git:git@github.com/fbaierl/scalajs-cross-compile-tarjan.git",
      Some("scm:git:git@github.com/fbaierl/scalajs-cross-compile-tarjan.git"))),
    publishMavenStyle := true,
    isSnapshot := false,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    pomExtra :=
      <developers>
      <developer>
        <id>fbaierl</id>
        <name>Florian Baierl</name>
        <url>https://github.com/fbaierl</url>
      </developer>
    </developers>,
    pomIncludeRepository := { _ => false }
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val tarjanJVM = tarjan.jvm
lazy val tarjanJS = tarjan.js

