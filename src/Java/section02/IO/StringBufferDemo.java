class StringBufferDemo {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("Hello");

		System.out.println("buffer: " + sb);
		System.out.println("buffer length: " + sb.length());
		System.out.println("buffer capacity: " + sb.capacity());

		sb.append(", StringBuffer!");

		System.out.println(sb);
	}
}