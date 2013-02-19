package testng.delay.demo;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	@BeforeMethod(alwaysRun = true)
	public void announceStarting(Method method) {
		announce(method, "Starting: ");
	}

	@AfterMethod(alwaysRun = true)
	public void announceDone(Method method) {
		announce(method, "Done:     ");
	}

	protected void simulateDelay(Method method, long delay) {
		announce(method, "Sleeping: ");
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {}
		announce(method, "Waking:   ");
	}

	private void announce(Method method, String status) {
		System.out.println(status + '[' + Thread.currentThread().getName() + "] " + method);
	}
	
	protected void reportDelay(long from, long to) {
		System.out.println(to - from + "ms delay between end of free method and start of dependent method for class " + getClass());
	}
}
