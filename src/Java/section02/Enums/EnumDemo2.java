enum Apple {
	Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

	private int price;

	Apple(int p) { price = p; }

	Apple() { price = -1; }

	int getPrice() { return price; }
}

class EnumDemo2 {
	public static void main(String[] args) {
		
		Apple ap;

		System.out.println("Winesap costs " + Apple.Winesap.getPrice() + " cents.\n");

		System.out.println("All apple prices:");

		for (var a : Apple.values())
			System.out.println(a + " costs " + a.getPrice() + " cents.");
	}
}
