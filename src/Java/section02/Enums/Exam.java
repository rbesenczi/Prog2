enum Grades {
	FAIL, PASS, SATISFACTORY, GOOD, EXCELLENT
}

class Grading {

	java.util.Random rand = new java.util.Random();

	Grades giveGrade() {

		int prob = (int) (100*rand.nextDouble());

		if (prob < 30)
			return Grades.FAIL;
		else if (prob < 50)
			return Grades.PASS;
		else if (prob < 80)
			return Grades.SATISFACTORY;
		else if (prob < 90)
			return Grades.GOOD;
		else 
			return Grades.EXCELLENT;
	}
}

class Exam {
	static void commit (Grades result) {

		switch(result) {
			case FAIL:
				System.out.println("Fail");
				break;
			case PASS:
				System.out.println("Pass");
				break;
			case SATISFACTORY:
				System.out.println("Satisfactory");
				break;
			case GOOD:
				System.out.println("Good");
				break;
			case EXCELLENT:
				System.out.println("Excellent");
				break;
		}
	}

	public static void main(String[] args) {
		Grading g = new Grading();
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());
	}
}
