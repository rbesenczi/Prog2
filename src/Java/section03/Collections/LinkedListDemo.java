class LinkedListDemo {
	public static void main(String[] args) {
		
		java.util.LinkedList<String> ll = new java.util.LinkedList<String>();

		System.out.println("Initial size of ll: " + ll.size());

		ll.add("C");
		ll.add("A");
		ll.add("E");
		ll.add("B");
		ll.add("D");
		ll.add("F");
		ll.add(1, "A2");

		System.out.println("Size of ll after additions: " + ll.size());

		System.out.println("Contents of ll: " + ll);

		ll.remove("F");
		ll.remove(2);

		System.out.println("Size of ll after deletions: " + ll.size());

		System.out.println("Contents of ll: " + ll);

		String sarray[] = new String[ll.size()];

		sarray = ll.toArray(sarray);

		for (var s : sarray)
			System.out.println(s);
	}
}
