package net.joaoqalves

import akka.actor.{Props, ActorSystem}
import spray.can._
import akka.io.IO

/**
* Main application of the net.joaoqalves when launched via spray-can.
*/
object Boot extends App with EngineApp {
  doInit()
}

