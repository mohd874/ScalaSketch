package worksheets

object Actors {
  val actor1 = new HiActor                        //> actor1  : worksheets.HiActor = HiActor()
  
  actor1 start                                    //> res0: scala.actors.Actor = HiActor()
  
  val hi = actor1 ! "Hi"                          //> hi  : Unit = ()
  
  val hey = actor1 ! "Hey"                        //> hey  : Unit = ()
  
  val stop = actor1 ! "stop"                      //> stop  : Unit = ()
}

import scala.actors.Actor

case class HiActor extends Actor{
	var run = true
	def act() {
		while (run){
			receive {
				case "Hi" => "Hello"
				case "stop" => {run = false; "Stopping the actor..."}
				case _ => "Whatever"
			}
		}
	}
}