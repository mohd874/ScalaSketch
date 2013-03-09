package worksheets

import java.io.File
import javax.imageio.ImageIO

//Ref: https://github.com/tototoshi/play-ascii-art-plugin/blob/master/src/main/scala/AAPlugin.scala
object Image2Acsii {
  val file = new File("/home/mohamed/workspace/acsii/A.png")
                                                  //> file  : java.io.File = /home/mohamed/workspace/acsii/A.png
  
  val img = ImageIO.read(file)
  val h = img getHeight
  val w = img getWidth
  
  def convert = {
  	for (y <- 0 until h) yield {
  		for (x <- 0 until w) yield {
  			img.getRGB(x,y) match {
  				case -1 => " "
  				case _ => "#"
  			}
  		}
  	}
  }
  val acsii = convert map (_.mkString) mkString "\n"
}