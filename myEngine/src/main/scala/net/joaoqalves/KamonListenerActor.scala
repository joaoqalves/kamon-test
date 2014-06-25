package net.joaoqalves

import akka.actor.{ActorLogging, Actor}
import kamon.metrics.Subscriptions.TickMetricSnapshot

class KamonListenerActor extends Actor with ActorLogging {

  def receive = {
    case tickSnapshot: TickMetricSnapshot =>
      log.info(tickSnapshot.metrics.toString())
  }

}
