class NonGen {
	int num;

	NonGen(int n) { num = n; }

	int getNum() { return num; }
}

class Gen<T> extends NonGen {
	T ob;

	Gen(int n, T o) { 
		super(n);
		ob = o; 
	}

	T getob() { return ob; }
}

class Gen2<T, V> extends Gen<T> {
	V ob2;

	Gen2(int n, T o, V o2) {
		super(n, o);
		ob2 = o2;
	}

	V getob2() {
		return ob2;
	}
}

class HierDemo2 {
	public static void main(String[] args) {
		
		Gen2<String, Integer> x =
			new Gen2<String, Integer>(1, "Values are: ", 420);

		System.out.print(x.getob());
		System.out.print(x.getNum());
		System.out.print(" and ");
		System.out.println(x.getob2());
	}
}