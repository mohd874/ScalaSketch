package worksheets

import java.io.File
import javax.imageio.ImageIO

//Ref: https://github.com/tototoshi/play-ascii-art-plugin/blob/master/src/main/scala/AAPlugin.scala
object Image2Acsii {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(251); 
  val file = new File("/home/mohamed/workspace/acsii/A.png");System.out.println("""file  : java.io.File = """ + $show(file ));$skip(34); 
  
  val img = ImageIO.read(file);System.out.println("""img  : java.awt.image.BufferedImage = """ + $show(img ));$skip(24); 
  val h = img getHeight;System.out.println("""h  : Int = """ + $show(h ));$skip(23); 
  val w = img getWidth;System.out.println("""w  : Int = """ + $show(w ));$skip(178); 
  
  def convert = {
  	for (y <- 0 until h) yield {
  		for (x <- 0 until w) yield {
  			img.getRGB(x,y) match {
  				case -1 => " "
  				case _ => "#"
  			}
  		}
  	}
  };System.out.println("""convert: => scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[java.lang.String]]""");$skip(53); 
  val acsii = convert map (_.mkString) mkString "\n";System.out.println("""acsii  : String = """ + $show(acsii ))}
}