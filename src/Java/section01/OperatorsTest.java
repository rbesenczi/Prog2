class OperatorsTest {

	public static void main(String[] args) {

		int a = 10;
		int b = 3;

		System.out.println("a+b=" + (a + b));
		System.out.println("a-b=" + (a - b));
		System.out.println("a*b=" + (a * b));
		System.out.println("a/b=" + ((double)a / b));
		System.out.println("a%b=" + (a % b));
		System.out.println("a++=" + ++a);
		System.out.println("a--=" + --a);

		boolean yes = true;
		boolean no = false;

		System.out.println("yes and no is " + (yes && no));
		System.out.println("yes or no is " + (yes || no));

		System.out.println("yes == no is " + (yes == no));

		int k = 9;

		int c = k > 8 ? k : b;

		System.out.println("C is " + c);
	}
}
