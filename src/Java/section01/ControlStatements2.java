class ControlStatements2 {
	public static void main(String[] args) {
		
		int n = 10;
		while (n > 0) {
			System.out.println("tick: " + n);
			n--;
		}

		n = 10;

		do {
			System.out.println("tick: " + n);
			n--;
		} while (n > 0);

		for (n = 10; n > 0; n--)
			System.out.println("tick: " + n);

		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int sum = 0;

		for (int num : nums) {
			System.out.println("Number: " + num);
			sum += num;
		}
		System.out.println("Average: " + sum/nums.length);
		System.out.println("nums length: " + nums.length);

		// break, continue, etc.
	}
}