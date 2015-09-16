object Scratch {
	sealed trait Shape {
		def perimeter: Double
		def area: Double
	}
	
	sealed trait Rectangular extends Shape {
		def hight: Double
		def width: Double
		
		def area: Double = hight * width
		def perimeter: Double = 2 * (hight + width)
	}
	
	case class Rectangle(hight: Double, width: Double) extends Rectangular
	
	case class Square(side: Double) extends Rectangular {
		val hight: Double = side
		val width: Double = side
	}
	
	def shapeName(shape: Shape): String = shape match {
		case Rectangle(_, _) => "Rectangle"
		case Square(_) => "Square"
	}                                         //> shapeName: (shape: Scratch.Shape)String
	
	val shape: Shape = Square(323.2)          //> shape  : Scratch.Shape = Square(323.2)
	shapeName(shape)                          //> res0: String = Square
	shape.area                                //> res1: Double = 104458.23999999999
	shape.perimeter                           //> res2: Double = 1292.8
}