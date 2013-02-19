package testng.delay.demo;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestClass10 extends TestBase {
	long endOfFreeMethod;

	@Test
	public void freeMethod(Method method) {
		simulateDelay(method, 10);
		endOfFreeMethod = System.currentTimeMillis();
	}
	
	@Test(dependsOnMethods="freeMethod")
	public void dependentMethod(Method method) {
		long startOfDependentMethod = System.currentTimeMillis();
		reportDelay(endOfFreeMethod, startOfDependentMethod);
	}
}
