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
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(568); 
	
	def shapeName(shape: Shape): String = shape match {
		case Rectangle(_, _) => "Rectangle"
		case Square(_) => "Square"
	};System.out.println("""shapeName: (shape: Scratch.Shape)String""");$skip(36); 
	
	val shape: Shape = Square(323.2);System.out.println("""shape  : Scratch.Shape = """ + $show(shape ));$skip(18); val res$0 = 
	shapeName(shape);System.out.println("""res0: String = """ + $show(res$0));$skip(12); val res$1 = 
	shape.area;System.out.println("""res1: Double = """ + $show(res$1));$skip(17); val res$2 = 
	shape.perimeter;System.out.println("""res2: Double = """ + $show(res$2))}
}
