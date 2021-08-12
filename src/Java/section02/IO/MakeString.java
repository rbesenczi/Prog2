class MakeString{
	public static void main(String[] args) {
		
		char c[] = {'A', 'l', 'a', 'd', 'á', 'r'};
		String aladár = new String(c);

		System.out.println(aladár);

		byte ascii[] = {65, 66, 67, 68, 69};
		String as = new String(ascii);

		System.out.println(as);
		System.out.println("as length: " + as.length());

		String literal = "Literal";
		System.out.println(literal);

		String newString = literal + " is good.";
		System.out.println(newString);

		String literalWithLength = literal + " is " + literal.length() + " character long.";
		System.out.println(literalWithLength);
	}
}
