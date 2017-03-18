import sbt._

object Dependencies {
  lazy val service = Compile.dependencies ++ TestUtils.dependencies

  object Compile {
    lazy val dependencies = Seq()
  }

  object TestUtils {
    lazy val dependencies = Seq(scalaTest)

    val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  }
}