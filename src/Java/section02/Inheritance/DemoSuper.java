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
		super();
		weight = -1;
	}

	BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}
}

class DemoSuper {
	public static void main(String[] args) {
		
		BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
		BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);
		BoxWeight myBox3 = new BoxWeight();
		BoxWeight myCube = new BoxWeight(3, 2);
		BoxWeight myClone = new BoxWeight(myBox1);

		double vol;

		vol = myBox1.volume();
		System.out.println("Volume of myBox1 is " + vol);
		System.out.println("Weight of myBox1 is " + myBox1.weight);
		System.out.println();

		vol = myBox2.volume();
		System.out.println("Volume of myBox2 is " + vol);
		System.out.println("Weight of myBox2 is " + myBox2.weight);
		System.out.println();

		vol = myBox3.volume();
		System.out.println("Volume of myBox3 is " + vol);
		System.out.println("Weight of myBox3 is " + myBox3.weight);
		System.out.println();

		vol = myCube.volume();
		System.out.println("Volume of myCube is " + vol);
		System.out.println("Weight of myBox1 is " + myCube.weight);
		System.out.println();

		vol = myClone.volume();
		System.out.println("Volume of myClone is " + vol);
		System.out.println("Weight of myClone is " + myClone.weight);
		System.out.println();
	}
}