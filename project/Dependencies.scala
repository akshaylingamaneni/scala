import sbt._

object Dependencies {
  // Define dependency versions in one place for maintainability
  object Versions {
    val ScalaTest = "3.2.16"
    val MUnit = "1.0.0-M10"
  }

  // List dependencies
  val ScalaTest = "org.scalatest" %% "scalatest" % Versions.ScalaTest % Test
  val MUnit = "org.scalameta" %% "munit" % Versions.MUnit % Test

  // Aggregate all dependencies
  val all: Seq[ModuleID] = Seq(ScalaTest, MUnit)
}
