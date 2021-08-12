class Stats<T extends Number> {
	
	T[] nums;

	Stats(T[] o) { nums = o; }

	double average() {
		
		double sum = 0.0;

		for(int i = 0; i < nums.length; i++)
			sum += nums[i].doubleValue();

		return sum / nums.length;
	}

	boolean sameAvg(Stats<?> ob) {
		
		if(average() == ob.average()) 
			return true;
		
		return false;
	}
}

class BoundDemo {
	public static void main(String[] args) {
		
		Integer inums[] = { 1, 2, 3, 4, 5 };
		Stats<Integer> iob = new Stats<Integer>(inums);
		double v = iob.average();
		System.out.println("inums average is " + v);

		Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Stats<Double> dob = new Stats<Double>(dnums);
		double w = dob.average();
		System.out.println("dnums average is " + w);

		Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
		Stats<Float> fob = new Stats<Float>(fnums);
		double x = fob.average();
		System.out.println("fnums average is " + x);

		System.out.print("Averages of iob and dob ");
		if(iob.sameAvg(dob))
			System.out.print("are the same.\n");
		else
			System.out.print("differ.\n");

		System.out.print("Averages of iob and fob ");
		if(iob.sameAvg(fob))
			System.out.print("are the same.\n");
		else
			System.out.print("differ.\n");

		/*	ERROR!
		String str[] = {"1", "2", "3", "4", "5"};
		Stats<String> strob = new Stats<String>(str);
		double x = strob.average();
		System.out.println("str average is " + x);
		*/		
	}
}
