class Stack {
	private int stck[] = new int[10];
	private int tos;

	Stack() {
		tos = -1;
	}

	public void push(int item) {
		if (tos == 9)
			System.out.println("Stack is full.");
		else
			stck[++tos] = item;
	}

	public int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow.");
			return 0;
		}
		else
			return stck[tos--];
	}

}

class TestStack2 {
	public static void main(String[] args) {
		Stack myStack1 = new Stack();
		Stack myStack2 = new Stack();

		for(int i = 0; i < 10; i++) myStack1.push(i);
		for(int i = 10; i < 20; i++) myStack2.push(i);

		System.out.println("Stack in myStack1:");
		for(int i = 0; i < 10; i++) System.out.println(myStack1.pop());

		System.out.println("Stack in myStack2:");
		for(int i = 0; i < 10; i++) System.out.println(myStack2.pop());

		// myStack2.tos = 0; // Error!
	}
}
