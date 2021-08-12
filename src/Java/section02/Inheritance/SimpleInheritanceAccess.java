class A {
	int i;
	private int j;

	void setij(int x, int y) {
		i = x;
		j = y;
	}

	void showij() {
		System.out.println("i and j: " + i + " " + j);
	}
}

class B extends A {
	int k;

	void showk() {
		System.out.println("k: " + k);
	}

	void sum() {
		System.out.println("i+j+k==" + (i+j+k)); //ERROR, j has private access
	}
}

class SimpleInheritanceAccess {

	public static void main(String[] args) {
		
		B subOb = new B();

		subOb.setij(7, 8);

		subOb.k = 9;

		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();
		System.out.println();

		System.out.println("Sum of i, j and k is subOb:");
		subOb.sum();
	}
}