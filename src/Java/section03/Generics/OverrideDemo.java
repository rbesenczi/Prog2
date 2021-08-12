class Gen<T> {
	T ob;

	Gen(T o) { ob = o; }

	T getob() {
		System.out.println("Gen's getob()");
		return ob; 
	}
}

class Gen2<T> extends Gen<T> {

	Gen2(T o) {
		super(o);
	}

	T getob() {
		System.out.println("Gen2's getob()");
		return ob;
	}
}

class OverrideDemo {
	public static void main(String[] args) {
		
		Gen<Integer> iOb = new Gen<Integer>(88);
		
		Gen2<Integer> iOb2 = new Gen2<Integer>(99);

		Gen2<String> strOb = new Gen2<String>("Testing generics");

		System.out.println(iOb.getob());
		System.out.println(iOb2.getob());
		System.out.println(strOb.getob());

	}
}