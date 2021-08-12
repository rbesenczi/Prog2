class TinyEdit {
	public static void main(String[] args) throws java.io.IOException {
		
		String str[] = new String[100];

		java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

		System.out.println("Enter lines, 'stop' to quit.");

		for (int i = 0; i < 100; i++) {
			str[i] = br.readLine();
			if (str[i].equals("stop")) break;
		}

		System.out.println("Here is the text:");

		for (int i = 0; i < 100; i++) {
			if(str[i].equals("stop")) break;
			System.out.println(str[i]);
		}
	}
}
