class ArrayExample {
	
	public static void main(String[] args) {
		
		/*
		int monthDays[];

		monthDays = new int[12];

		monthDays[0] = 31;
		monthDays[1] = 28;
		monthDays[2] = 31;
		monthDays[3] = 30;
		monthDays[4] = 31;
		monthDays[5] = 30;
		monthDays[6] = 31;
		monthDays[7] = 31;
		monthDays[8] = 30;
		monthDays[9] = 31;
		monthDays[10] = 30;
		monthDays[11] = 31;
	 	*/
		
		int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		System.out.println("April has " + monthDays[3] + " days.");

		int twoD[][] = new int[4][5];
		var k = 0;

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 5; j++) {
				twoD[i][j] = k;
				k++;
			}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(twoD[i][j] + " ");
			System.out.println();	
		}	
	}
}
