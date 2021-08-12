class ArrayListDemo {
	public static void main(String[] args) {
		
		java.util.ArrayList<String> al = new java.util.ArrayList<String>();

		System.out.println("Initial size of al: " + al.size());

		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add(1, "A2");

		System.out.println("Size of al after additions: " + al.size());

		System.out.println("Contents of al: " + al);

		al.remove("F");
		al.remove(2);

		System.out.println("Size of al after deletions: " + al.size());

		System.out.println("Contents of al: " + al);

		String sarray[] = new String[al.size()];

		sarray = al.toArray(sarray);

		for (var s : sarray)
			System.out.println(s);
	}
}
