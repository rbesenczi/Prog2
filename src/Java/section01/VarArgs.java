class VarArgs {
	static void vaTest(int ... v) {
		
		System.out.println("Number of args: " + v.length + 
			", contents: ");
		
		for (int i : v)
			System.out.println(i + " ");

		System.out.println();
	}

	static void vaTest(boolean ... v) {
		
		System.out.println("Number of args: " + v.length + 
			", contents: ");
		
		for (boolean i : v)
			System.out.println(i + " ");

		System.out.println();
	}

	static void vaTest(String msg, boolean ... v) {
		
		System.out.println(msg + "Number of args: " + v.length + 
			", contents: ");
		
		for (boolean i : v)
			System.out.println(i + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		
		vaTest(10);
		vaTest(1, 2, 3);

		vaTest(true);
		vaTest(true, false, false);

		vaTest("Hello boolean! ", true);
		vaTest("Yes boolean! ", true, false, false);
		vaTest("No boolean! ");
	}
}
