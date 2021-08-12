class A {
	int i, j;

	A(int a, int b) {
		i = a;
		j = b;
	}

	void show() {
		System.out.println("i and j: " + i + " " + j);
	}
}

class B extends A {
	int k;

	B(int a, int b, int c) {
		super(a, b);
		k = c;
	}

	void show() {
		super.show();
		System.out.println("k: " + k);
	}
}

class Override {
	public static void main(String[] args) {
		
		B subOb = new B(1, 2, 3);

		subOb.show();
	}
}
