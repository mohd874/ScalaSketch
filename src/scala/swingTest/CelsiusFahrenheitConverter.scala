package scala.swingTest

import scala.swing._
import scala.swing.TextField
import scala.swing.event._

object CelsiusFahrenheitConverter extends SimpleSwingApplication{

  def top = new MainFrame {
    title = "Celsius/Fahrenheit converter"
    val btnConvert = new Button {text = "convert"}
    val txtC = new TextField
    val txtF = new TextField
    
    contents = new BoxPanel(Orientation.Horizontal){
      contents += new Label {text = "Celsius"}
      contents += txtC 
	  contents += new Label {text = "Fahrenheit"}
      contents += txtF
      contents += btnConvert
      border = Swing.LineBorder(new Color(0,0,0))
    }
    
    listenTo(btnConvert)
    reactions += {
      case ButtonClicked(b) => convert
    }
    
    def convert = {
      val c = txtC.text.toInt
      val f =  c * 9 / 5 + 32
      txtF.text = f toString
    }
  }
}