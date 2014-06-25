package net.joaoqalves.rest

import akka.actor._
import kamon.trace.TraceRecorder

class InitActor
  extends Actor
  with ActorLogging  {

  import InitActor._

  override def receive = {
    case Init =>
      log.info("Initializing")
      Thread.sleep(4000) // Just testing
      self ! UpperCase("test")
    case UpperCase(x) =>
      log.info(x.toUpperCase)
      log.info("finishing!")
      TraceRecorder.finish()
  }
}

object InitActor {
  sealed trait InitActorProtocol
  case object Init extends InitActorProtocol
}

case class UpperCase(string: String)
