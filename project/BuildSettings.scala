import sbt._
import AspectJ.aspectJSettings

object BuildSettings {
  import Keys._

  lazy val basicSettings = Seq(
    version               := "1.0-SNAPSHOT",
    organization          := "net.joaoqalves",
    scalaVersion          := "2.10.3",
    credentials           += Credentials(Path.userHome / ".sbt" / ".credentials"),
    javaOptions           += "-XX:+HeapDumpOnOutOfMemoryError",
    scalacOptions         := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.7",
      "-Xlog-reflective-calls"
    ),
    // for WAR packing
    exportJars           := true,

    // generate junit report
    testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")
  ) ++ aspectJSettings

  lazy val sprayRunSettings = spray.revolver.RevolverPlugin.Revolver.settings
}
