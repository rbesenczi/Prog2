class ValueTest {
	void meth(int i, int j) {
		i *= 2;
		j /= 2;
	}
}

class ReferenceTest {

	int a, b;

	ReferenceTest(int i, int j) {
		a = i;
		b = j;
	}

	void meth(ReferenceTest o) {
		o.a *= 2;
		o.b /= 2;
	}
}

class ArgPassDemo {
	public static void main(String[] args) {
		
		ValueTest valOb = new ValueTest();

		int a = 15, b = 20;	// primitive types

		System.out.println("a and b before call: " + a + " " + b);

		valOb.meth(a, b);

		System.out.println("a and b after call: " + a + " " + b);

		/********************/

		ReferenceTest refOb = new ReferenceTest(15, 20); //class types

		System.out.println("refOb.a and refOb.b before call: " + 
			refOb.a + " " + refOb.b);

		refOb.meth(refOb);

		System.out.println("refOb.a and refOb.b before call: " + 
			refOb.a + " " + refOb.b);
	}
}