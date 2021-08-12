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

class HierDemo {
	public static void main(String[] args) {
		
		Gen2<String, Integer> x =
			new Gen2<String, Integer>("Value is: ", 420);

		System.out.print(x.getob());
		System.out.println(x.getob2());
	}
}