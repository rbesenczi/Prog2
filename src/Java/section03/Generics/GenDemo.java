class Gen<T> {

	T ob;

	Gen(T o) { ob = o; }

	T getob() { return ob; }

	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}

class GenDemo {
	public static void main(String[] args) {
		
		Gen<Integer> iOb;

		iOb = new Gen<Integer>(88);

		iOb.showType();

		int v = iOb.getob();

		System.out.println("Value: " + v);

		System.out.println();

		Gen<String> strOb = new Gen<String>("Generics test.");

		strOb.showType();

		String str = strOb.getob();

		System.out.println("value: " + str);

		iOb = strOb; //Error!
	}
}
