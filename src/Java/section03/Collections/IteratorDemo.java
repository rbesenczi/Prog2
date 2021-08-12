class IteratorDemo {
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

		System.out.println("Contents of al: ");

		java.util.Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}

		System.out.println();

		java.util.ListIterator<String> litr = al.listIterator();
		while(litr.hasNext()) {
			String element = litr.next();
			litr.set(element + "+");
		}

		itr = al.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}

		System.out.println();

	}
}
