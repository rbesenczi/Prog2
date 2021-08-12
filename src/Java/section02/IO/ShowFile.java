class ShowFile {
	public static void main(String[] args) {
		
		int i;
		java.io.FileInputStream fin;

		if(args.length != 1) {
			System.out.println("Usage: ShowFile filename");
			return;
		}

		try {
			fin = new java.io.FileInputStream(args[0]);
		} catch (java.io.FileNotFoundException e) {
			System.out.println("Cannot open file.");
			return;
		}

		try {
			do {
				i = fin.read();
				if (i != -1) System.out.print((char)i);
			} while (i != -1);
		} catch (java.io.IOException e) {
			System.out.println("Error Reading File.");
		}

		try {
			fin.close();
		} catch (java.io.IOException e) {
			System.out.println("Error Closing File.");
		}
	}
}
