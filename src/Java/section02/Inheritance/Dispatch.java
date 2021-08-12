class A {
	void callme() {
		System.out.println("This is A's callme()");
	}
}

class B extends A {
	void callme() {
		System.out.println("This is B's callme()");
	}
}

class C extends B {
	void callme() {
		System.out.println("This is C's callme()");
	}
}

class Dispatch {
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		C c = new C();

		A r;
		r = a;
		r.callme();

		r = b;
		r.callme();

		r = c;
		r.callme();
	}
}