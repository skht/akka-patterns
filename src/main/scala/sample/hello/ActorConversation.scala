package sample.hello

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props


class ActorConversation extends Actor {
  def receive = {
    case "hello" => println("hello back to you")
    case _       => println("huh?")
  }
}

object StartActorConversation extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[ActorConversation], name ="helloactor")
  
  helloActor ! "hello"
  helloActor ! "buenos dias"
  
  system.shutdown
}