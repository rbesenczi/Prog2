interface IntStack {
	void push(int item);
	int pop();
}

class FixedStack implements IntStack {
	private int stck[];
	private int tos;

	FixedStack(int size) {
		stck = new int[size];
		tos = -1;
	}

	public void push(int item) {
		if (tos == stck.length-1)
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

class IFTest {
	public static void main(String[] args) {

		FixedStack myStack1 = new FixedStack(5);
		FixedStack myStack2 = new FixedStack(8);

		for(int i = 0; i < 5; i++) myStack1.push(i);
		for(int i = 0; i < 8; i++) myStack2.push(i);

		System.out.println("Stack in myStack1:");
		for(int i = 0; i < 5; i++) System.out.println(myStack1.pop());

		System.out.println("Stack in myStack2:");
		for(int i = 0; i < 8; i++) System.out.println(myStack2.pop());

	}
}
