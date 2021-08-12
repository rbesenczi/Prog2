class Box {
	private double width;
	private double height;
	private double depth;

	Box(Box ob) {
		width = ob.width;
		height = ob.height;
		depth = ob.depth;
	}

	Box(double w, double h, double d) {
		width = w;
		height = h;
		depth = d;
		System.out.println("Box constructor");
	}

	Box() {
		width = -1;
		height = -1;
		depth = -1;
		System.out.println("Box() constructor");
	}

	Box(double len) {
		width = height = depth = len;
	}

	double volume () {
		return width * height * depth;
	}
}

class BoxWeight extends Box {

	double weight;

	BoxWeight(BoxWeight ob) {
		super(ob);
		weight = ob.weight;
	}

	BoxWeight(double w, double h, double d, double m) {
		super(w, h, d); // calling superclass constructor
		weight = m;
		System.out.println("BoxWeight constructor");
	}

	BoxWeight() {
		weight = -1;
		System.out.println("BoxWeight() constructor");
	}

	BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}
}

class Shipment extends BoxWeight {

	double cost;

	Shipment(Shipment ob) {
		super(ob);
		cost = ob.cost;
	}

	Shipment(double w, double h, double d, double m, double c) {
		super(w, h, d, m); // calling superclass constructor
		cost = c;
		System.out.println("Shipment constructor");
	}

	Shipment() {
		cost = -1;
		System.out.println("Shipment() constructor");
	}

	Shipment(double len, double m, double c) {
		super(len, m);
		cost = c;
	}
}

class DemoShipment {
	public static void main(String[] args) {
		
		Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
		Shipment shipment2 = new Shipment(2, 3, 4, 0.76, 1.28);

		double vol;

		vol = shipment1.volume();

		System.out.println("Volume of shipment1 is " + vol);
		System.out.println("Weight of shipment1 is " + shipment1.weight);
		System.out.println("Cost of shipment1 is $" + shipment1.cost);
		System.out.println();

		vol = shipment2.volume();

		System.out.println("Volume of shipment2 is " + vol);
		System.out.println("Weight of shipment2 is " + shipment2.weight);
		System.out.println("Cost of shipment2 is $" + shipment2.cost);
		System.out.println();

		Shipment shipment3 = new Shipment();
	}
}
