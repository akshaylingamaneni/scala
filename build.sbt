ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "learn",
    idePackagePrefix := Some("org.acl"),
    libraryDependencies ++= Dependencies.all
  )
