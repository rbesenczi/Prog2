class CopyFile {
	public static void main(String[] args) {
		
		int i;
		java.io.FileInputStream fin = null;
		java.io.FileOutputStream fout = null;

		if(args.length != 2) {
			System.out.println("Usage: ShowFile in_filename out_filename");
			return;
		}

		try {
			fin = new java.io.FileInputStream(args[0]);
			fout = new java.io.FileOutputStream(args[1]);
		
			do {
				i = fin.read();
				if (i != -1) {
					System.out.print((char)i);
					fout.write(i);
				}
			} while (i != -1);


		} catch (java.io.FileNotFoundException e) {
			System.out.println("Cannot open file.");
			return;
		} catch (java.io.IOException e) {
			System.out.println("Error Reading File." + e);
			System.out.println();
		} finally {
			try {
				if (fin != null) fin.close();
			} catch (java.io.IOException e2) {
				System.out.println("Error Closing Input File.");
			}
			try{
				if(fout != null) fout.close();
			} catch (java.io.IOException e2) {
				System.out.println("Error Closing Output File.");
			}
		}
	}
}
