class AutoBox {

	static int m(Integer v) {
		return v;
	}

	public static void main(String[] args) {
		
		Integer iOb = Integer.valueOf(100);

		int i = iOb.intValue();

		System.out.println(i + " " + iOb);

		iOb = 200;	// autobox an int

		i = iOb;	//auto-unbox

		System.out.println(i + " " + iOb);

		Integer iOb2 = m(420);

		System.out.println(iOb2);

		++iOb2;

		System.out.println(iOb2);

		iOb2 = iOb2 + (iOb / 3);

		System.out.println(iOb2);
	}
}
