import sbt._

object Dependencies {
  import Keys._

  object Versions {
    val slf4j = "1.6.2"
    val aspectJ = "1.7.4"
    val spray = "1.3.1"
    val akka = "2.3.3"
  }


  def asCompile (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def asProvided (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def asTest (dep: ModuleID): Seq[ModuleID] = Seq(dep) map (_ % "test")
  def asTest (deps: Seq[ModuleID]): Seq[ModuleID] = deps map (_ % "test")
  def asRuntime (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")
  def asContainer (dep: ModuleID): Seq[ModuleID] = Seq(dep) map (_ % "container")
  def asContainer (deps: Seq[ModuleID]): Seq[ModuleID] = deps map (_ % "container")

  val slf4j = "org.slf4j" % "slf4j-api" % Versions.slf4j force()
  val slf4j_log4j = "org.slf4j" % "slf4j-log4j12" % Versions.slf4j force()

  val logstashEncoder = "net.logstash.logback" % "logstash-logback-encoder" % "2.6"

  val sprayRouting = "io.spray" % "spray-routing" % Versions.spray
  val sprayCaching = "io.spray" % "spray-caching" % Versions.spray
  val sprayClient = "io.spray" % "spray-client" % Versions.spray
  val sprayServlet = "io.spray" % "spray-servlet" % Versions.spray
  val sprayTestKit = "io.spray" % "spray-testkit" % Versions.spray
  val sprayJson = "io.spray" %% "spray-json" % "1.2.5"

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % Versions.akka
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % Versions.akka
  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % Versions.akka

  val typesafeConfig = "com.typesafe" % "config" % "1.0.0"

  val nscalaTime = "com.github.nscala-time" %% "nscala-time" % "1.2.0"

  val javaReflections = "org.reflections" % "reflections" % "0.9.9-RC1"

  val kamon = "io.kamon" %  "kamon-core" % "0.3.0"
  val aspectJ = "org.aspectj" % "aspectjrt" % Versions.aspectJ
  val aspectjWeaver = "org.aspectj" % "aspectjweaver" % Versions.aspectJ

  val casbah = "org.mongodb" %% "casbah" % "2.6.2"

  val junit = "junit" % "junit" % "4.11"
  val specs2 = Seq(
    "org.specs2" %% "specs2" % "2.2.2",
    junit)
  val scalaMeter = "com.github.axel22" %% "scalameter" % "0.3"
}
