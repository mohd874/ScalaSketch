package scala.swingTest

import scala.swing._
import scala.swing.event.ButtonClicked

object FirstSwingApp extends SimpleSwingApplication{
	def top = new MainFrame {
	  title = "First Swing App"
	  val button = new Button {
	    text = "Click Me"
	  }
	  val label = new Label {
	    text = "Nothing was clicked yet"
	  }
	  contents = new BoxPanel(Orientation.Vertical){
	    contents += button
	    contents += label
	    border = Swing.EmptyBorder(30, 30, 10, 30)
	  }
	  listenTo(button)
	  var nClicks = 0
	  reactions += {
	    case ButtonClicked(b) =>
	      nClicks += 1
	      label text = "Number of button Clicks: " + nClicks
	  }
	}
}