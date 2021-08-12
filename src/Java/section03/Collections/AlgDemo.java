class AlgDemo {
	public static void main(String[] args) {
		
		java.util.LinkedList<Integer> ll = new java.util.LinkedList<Integer>();
		ll.add(-8);
		ll.add(20);
		ll.add(-20);
		ll.add(8);

		java.util.Comparator<Integer> r = java.util.Collections.reverseOrder();

		java.util.Collections.sort(ll, r);

		for(var i : ll)
			System.out.print(i + " ");

		System.out.println();

		java.util.Collections.shuffle(ll);

		System.out.println("List shuffled: ");

		for(var i : ll)
			System.out.println(i + " ");
		
		System.out.println();

		System.out.println("Minimum: " + java.util.Collections.min(ll));
		System.out.println("Maximum: " + java.util.Collections.max(ll));
	}
}
