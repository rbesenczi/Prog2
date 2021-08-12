class NonGen {

	Object ob;

	NonGen(Object o) { ob = o; }

	Object getob() { return ob; }

	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}

class NonGenDemo {
	public static void main(String[] args) {
		
		NonGen iOb = new NonGen(88);

		iOb.showType();

		int v = (Integer) iOb.getob();

		System.out.println("Value: " + v);

		System.out.println();

		NonGen strOb = new NonGen("Generics test.");

		strOb.showType();

		String str = (String) strOb.getob();

		System.out.println("value: " + str);

		iOb = strOb; //Not an error, but will cause problems.

		int k = (Integer) iOb.getob(); //ClassCastException?
	}
}
