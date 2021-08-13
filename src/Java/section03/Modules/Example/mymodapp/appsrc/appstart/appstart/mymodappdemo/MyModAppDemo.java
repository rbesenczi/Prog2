/*
	from mymodapp dir:
	javac -d appmodules --module-source-path appsrc/ appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java
	java --module-path appmodules -m appstart/appstart.mymodappdemo.MyModAppDemo

*/

package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;

public class MyModAppDemo {
	public static void main(String[] args) {
		
		if(SupportFuncs.isFactor(2, 10))
			System.out.println("2 is a factor of 10");

		System.out.println(
			"Smallest factor common to both 35 and 105 is " + 
			SimpleMathFuncs.lcf(35, 105));

		System.out.println(
			"Largest factor common to both 35 and 105 is " + 
			SimpleMathFuncs.gcf(35, 105));
	}
}
