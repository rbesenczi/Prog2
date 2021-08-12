class ForTest {
	public static void main(String[] args) {
		int x;

		for (x = 0; x < 10; x++)
			System.out.println("This is x: " + x);

		// Blocks
		int y = 20;

		for (x = 0; x < 10; x++, y++) {
			System.out.println("This is x: " + x);
			System.out.println("This is y: " + y);
		}
	}
}
