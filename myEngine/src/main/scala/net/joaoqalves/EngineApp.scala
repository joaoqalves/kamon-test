package net.joaoqalves

import akka.actor.{ActorLogging, Actor, Props, ActorSystem}
import kamon.trace.TraceRecorder
import kamon.metrics.ActorMetrics.ActorMetricRecorder
import kamon.metrics.{ActorMetrics, Metrics}
import kamon.Kamon
import net.joaoqalves.rest.InitActor

trait EngineApp {
    implicit val system = ActorSystem("kamon-test")

    protected[this] val initActor = system.actorOf(Props(new InitActor()), "init-actor")

    val listener = system.actorOf(Props[KamonListenerActor], "kamon-listener")
    Kamon(Metrics).subscribe(ActorMetrics, "*", listener, permanently = true)
    def doInit() = TraceRecorder.withNewTraceContext("sample-trace") {
      initActor ! InitActor.Init
    }

}
