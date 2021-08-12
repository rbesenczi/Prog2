class Box {
	double width;
	double height;
	double depth;

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

	BoxWeight(double w, double h, double d, double m) {
		super(w, h, d); // calling superclass constructor
		weight = m;
	}
}

class RefDemo {
	public static void main(String[] args) {
		
		BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
		Box plainBox = new Box();
		
		double vol;

		vol = weightBox.volume();
		System.out.println("Volume of weightBox is " + vol);
		System.out.println("Weight of weightBox is " + weightBox.weight);
		System.out.println();

		plainBox = weightBox; //Assign subclass reference to superclass reference

		vol = plainBox.volume();

		System.out.println("Volume of plaionBox is " + vol);
		
		//ERROR, Box has no member weight. A referencia típusa határozza meg a hozzáférhető tagok körét.
		//System.out.println("Weight of plainBox is " + plainBox.weight);
	}
}