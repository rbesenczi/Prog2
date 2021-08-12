class StaticDemo {
	static int a = 30;
	static int b = 10;

	static int callMe(int param) {
		return a * b * param;
	}
}

class UseStatic {

	static int a = 3;
	static int b;

	static void meth(int x) {
		System.out.println("x==" + x);
		System.out.println("a==" + a);
		System.out.println("b==" + b);
	}

	static {
		System.out.println("Static block initialized.");
		b = a * 4;
	}

	public static void main(String[] args) {

		final int theAnswer = 42;

		meth(theAnswer);

		// theAnswer++;	//Error

		System.out.println(StaticDemo.callMe(theAnswer));
	}
}
