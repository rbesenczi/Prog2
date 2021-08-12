class Box {
	double width;
	double height;
	double depth;

	Box() {
		width = 0;
		height = 0;
		depth = 0;
	}

	Box(Box ob) {
		this.width = ob.width;
		this.height = ob.height;
		this.depth = ob.depth;
	}

	Box(double len) {
		width = height = depth = len;
	}

	Box(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	double volume() {
		return width * height * depth;
	}

	void setDim(double w, double h, double d) {
		width = w;
		height = h;
		depth = d;
	}

	void setDim(double len) {
		width = height = depth = len;
	}
}

class BoxDemo {
	public static void main(String[] args) {
		
		Box myBox = new Box();
		Box myBox2 = new Box();
		
		double vol = 0;

		myBox.width = 10.5;
		myBox.height = 12.4;
		myBox.depth = 2.3;

		vol = myBox.width * myBox.height * myBox.depth;

		System.out.println("Volume is " + vol);

		myBox2.width = 1.05;
		myBox2.height = 1.24;
		myBox2.depth = 20.3;

		/* Object reference demo
		Box tempBox = myBox2;
		myBox2 = myBox;
		*/

		vol = myBox2.width * myBox2.height * myBox2.depth;
		vol = myBox2.volume();

		System.out.println("Volume is " + vol);
		System.out.println("Volume of myBox is " + myBox.volume());
		System.out.println("Volume of myBox2 is " + myBox2.volume());

		myBox2.setDim(100,100,100);
		System.out.println("Volume of myBox2 is " + myBox2.volume());

		Box myBox3 = new Box();
		System.out.println("Volume of myBox3 is " + myBox3.volume());

		Box myBox4 = new Box(100,100,100);
		System.out.println("Volume of myBox4 is " + myBox4.volume());

		Box myBox5 = new Box(100);
		System.out.println("Volume of myBox5 is " + myBox5.volume());
		myBox5.setDim(200);
		System.out.println("Volume of myBox5 is " + myBox5.volume());

		Box myBox6 = new Box(myBox5);
		System.out.println("Volume of myBox6 is " + myBox6.volume());
	}
}
