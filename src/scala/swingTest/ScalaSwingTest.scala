package scala.swingTest

import javax.swing.JPanel
import java.awt.BorderLayout
import scala.swing._

object ScalaSwingTest extends SimpleSwingApplication{

  val panel = new JPanel
  panel.setLayout(new BorderLayout)
  
  def top = new MainFrame {
    title = "Scala Swing Test"
    contents = new Button {
    	text = "Click Me!"
    }
  }
}