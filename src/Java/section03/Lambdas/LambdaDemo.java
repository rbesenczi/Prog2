interface MyNumber {
	double getValue();
}

interface NumericTest {
	boolean test(int n);
}

class LambdaDemo {
	public static void main(String[] args) {
		
		MyNumber myNum;

		myNum = () -> 123.45;

		System.out.println("A fixed value: " + myNum.getValue());

		myNum = () -> Math.random() * 100;

		System.out.println("A random value: " + myNum.getValue());
		System.out.println("Another random value: " + myNum.getValue());

		NumericTest isEven = (n) -> (n % 2)==0;

		if(isEven.test(10)) System.out.println("10 is even.");
		if(!isEven.test(9)) System.out.println("9 is not even.");

		NumericTest isNonNeg = (n) -> n >= 0;

		if(isNonNeg.test(1)) System.out.println("1 is non-negative.");
		if(!isNonNeg.test(-1)) System.out.println("-1 is negative.");
	}
}