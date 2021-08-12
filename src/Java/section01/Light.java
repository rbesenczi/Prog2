class Light {
	public static void main(String[] args) {

		int lightspeed = 299792;
		long days = 1000;
		long seconds = days * 24 * 60 * 60;
		long distance = lightspeed * seconds;

		System.out.println("In " + days + 
			" days light will travel about " +
			distance + " km.");

		/*
			Other types: 
			Integers: byte, short, int, long,
			Floating-point numbers: float, double,
			Characters: char,
			Boolean: boolean.
			Literals...
		*/
	}
}
