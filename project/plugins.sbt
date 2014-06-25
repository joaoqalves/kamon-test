// for war file builds
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.7.0")

// dependency info
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

// fast turnaround / restart app
addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

// AspectJ support, currently for Kamon
addSbtPlugin("com.typesafe.sbt" % "sbt-aspectj" % "0.9.4")
