import sbt._
import Keys._

object Build extends Build {
  import BuildSettings._
  import Dependencies._

  lazy val root = Project(id = "root",
                          base = file("."))
    .settings(basicSettings: _*)
    .aggregate(myEngine)

  lazy val myEngine = Project(id = "myEngine",
                              base = file("myEngine"))
    .settings(basicSettings: _*)
    .settings(sprayRunSettings: _*)
    .settings(libraryDependencies ++=
      asCompile(logstashEncoder) ++
      asCompile(slf4j) ++
      asCompile(slf4j_log4j) ++
      asCompile(typesafeConfig) ++
      asCompile(nscalaTime) ++
      asCompile(casbah) ++
      asCompile(sprayRouting) ++
      asCompile(sprayCaching) ++
      asCompile(sprayClient) ++
      asCompile(sprayJson) ++
      asCompile(kamon) ++
      asCompile(akkaActor) ++
      asCompile(akkaSlf4j) ++
      asCompile(aspectJ) ++
      asCompile(aspectjWeaver) ++
      asTest(specs2) ++
      asTest(sprayTestKit) ++
      asTest(akkaTestKit) ++
      asTest(scalaMeter)
    )
}
