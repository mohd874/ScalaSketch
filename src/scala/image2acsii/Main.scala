import javax.imageio.ImageIO
import java.io.File
import java.awt.Color

object Main extends App{

  println("Welcome to Image2Acsii\n")
  
  val chars = List(" ","@","#","$","%","^","&","*",".",
   				   "~","A","0","X","?","\"","-","'","U",
  				   "V","T","8","<",">",":","=","!")
  
  if(args.length < 1){
    println("Need an image path!")
  }
  
  println("Converting file: "+args(0))
  val img = ImageIO.read(new File(args(0)))
  val h = img getHeight
  val w = img getWidth
  
  def color2char(c: Color) = {
    val color: Int = (List(c.getRed, c.getGreen, c.getBlue) reduceLeft (math.max))
    chars(color/10)
  }
  
  def convert = {
  	for (y <- 0 until h) yield {
  		for (x <- 0 until w) yield {
  			color2char(new Color(img.getRGB(x,y)))
  		}
  	}
  }
  println(convert map (_.mkString) mkString "\n")
}