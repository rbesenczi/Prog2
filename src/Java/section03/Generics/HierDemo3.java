class Gen<T> {
	T ob;

	Gen(T o) { ob = o; }

	T getob() { return ob; }
}

class Gen2<T, V> extends Gen<T> {
	V ob2;

	Gen2(T o, V o2) {
		super(o);
		ob2 = o2;
	}

	V getob2() {
		return ob2;
	}
}

class HierDemo3 {
	public static void main(String[] args) {
		
		Gen<Integer> iOb = new Gen<Integer>(88);
		Gen<Integer> iOb2 = new Gen<Integer>(99);

		Gen2<String, Integer> x =
			new Gen2<String, Integer>("Value is: ", 420);

		if(iOb instanceof Gen<?>)
			System.out.println("iOb is instance of Gen");

		if(iOb2 instanceof Gen<?>)
			System.out.println("iOb2 is instance of Gen");

		if(iOb2 instanceof Gen2<?,?>)
			System.out.println("iOb2 is instance of Gen2");

		if(x instanceof Gen2<?,?>)
			System.out.println("x is instance of Gen2");


	}
}