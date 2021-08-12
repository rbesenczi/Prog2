abstract class Figure {
	
	double dim1, dim2;

	Figure(double a, double b) {
		dim1 = a;
		dim2 = b;
	}

	abstract double area();
}

class Rectangle extends Figure {

	Rectangle(double a, double b) {
		super(a, b);
	}

	double area() {
		System.out.println("Inside area for Rectangle.");
		return dim1 * dim2;
	}
}

class Triangle extends Figure {

	Triangle(double a, double b) {
		super(a, b);
	}

	double area() {
		System.out.println("Inside area for Triangle.");
		return dim1 * dim2 / 2;
	}
}

class FindAreas {
	public static void main(String[] args) {
		
		//Figure f = new Figure(10, 10); //ERROR, Figure is abstract
		Rectangle r = new Rectangle(9, 5);
		Triangle t = new Triangle(10, 8);

		Figure figRef;

		figRef = r;
		System.out.println("Area is " + figRef.area());

		figRef = t;
		System.out.println("Area is " + figRef.area());

		/*
		figRef = f;
		System.out.println("Area is " + figRef.area());
		*/
	}
}
