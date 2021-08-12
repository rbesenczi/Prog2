import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str() default "Testing";
	int val() default 9000;
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description();
}

@What(description = "An annotation test class.")
@MyAnno(str = "Meta4")
class Meta4 {

	@What(description = "An annotation test method.")
	@MyAnno()
	public static void myMeth() {
		
		Meta4 ob = new Meta4();

		try {
			Annotation annos[] = ob.getClass().getAnnotations();	//reflection

			System.out.println("All annotations for Meta4:");

			for (Annotation a : annos)
				System.out.println(a);

			System.out.println();

			Method m = ob.getClass().getMethod("myMeth");

			annos = m.getAnnotations();

			System.out.println("All annotations for myMeth:");

			for (Annotation a : annos)
				System.out.println(a);

			System.out.println();

		} catch (NoSuchMethodException exc) {
			System.out.println("Method not found.");
		}
	}

	public static void main(String[] args) {
		myMeth();
	}
}
