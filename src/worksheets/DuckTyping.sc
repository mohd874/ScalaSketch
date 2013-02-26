package worksheets


//Source: http://java.dzone.com/articles/duck-typing-scala-structural
object DuckTyping {
  def quacker(duck: {def quack(value: String): String}) {
  	println (duck.quack("Quack"))
	}                                         //> quacker: (duck: AnyRef{def quack(value: String): String})Unit
	
	object BigDuck {
  def quack(value: String) = {
    value.toUpperCase
  }
	}
	
	object SmallDuck {
	  def quack(value: String) = {
	    value.toLowerCase
	  }
	}
	
	object IamNotReallyADuck {
	  def quack(value: String) = {
	    "prrrrrp"
	  }
	}
	
	quacker(BigDuck)                          //> QUACK
	quacker(SmallDuck)                        //> quack
	quacker(IamNotReallyADuck)                //> prrrrrp
	
	object NoQuaker {

	}

	// quacker(NoQuaker) //Gives error: type mismatch; found : this.NoQuaker.type required: AnyRef{def quack(value: String): String} quacker(NoQuaker)

	val x = new AnyRef {
	  def quack(value: String) = {
	   	 "No type needed "+ value
	  }
	}                                         //> x  : AnyRef{def quack(value: String): String} = worksheets.DuckTyping$$anonf
                                                  //| un$main$1$$anon$1@1e68ce4
	quacker(x)                                //> No type needed Quack
	
	def quacker2(duck: {def quack(value: String): String; def walk(): String}) {
  	println (duck.quack("Quack"))
	}                                         //> quacker2: (duck: AnyRef{def quack(value: String): String; def walk(): String
                                                  //| })Unit
}