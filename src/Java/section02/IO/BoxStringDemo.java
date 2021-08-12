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
	}

	Box() {
		width = -1;
		height = -1;
		depth = -1;
	}

	Box(double len) {
		width = height = depth = len;
	}

	double volume () {
		return width * height * depth;
	}

	public String toString() {
		return "Box size is " + width + " by " + height + " by " + depth + ".";
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
	}

	BoxWeight() {
		weight = -1;
	}

	BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}

	public String toString() {
		return "Box volume is " + volume() + ", weight is " + weight + ".";
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
	}

	Shipment() {
		cost = -1;
	}

	Shipment(double len, double m, double c) {
		super(len, m);
		cost = c;
	}

	public String toString() {
		return "Box volume is " + volume() + ", weight is " + weight + ", cost is " + cost + ".";
	}
}

class BoxStringDemo{
	public static void main(String[] args) {
		
		Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
		System.out.println(shipment1);
	}
}
