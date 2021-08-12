class BRRead2 {
	public static void main(String[] args) throws java.io.IOException {
		
		String str;
		java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

		System.out.println("Enter lines, 'stop' to quit.");

		do {
			str = br.readLine();
			System.out.println(str);
		} while (!str.equals("stop"));
	}
}
