class BRRead {
	public static void main(String[] args) throws java.io.IOException {
		
		char c;
		java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

		System.out.println("Enter characters, 'q' to quit.");

		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != 'q');
	}
}
