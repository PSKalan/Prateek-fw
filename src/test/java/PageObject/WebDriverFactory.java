package PageObject;

import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class WebDriverFactory {
static WebDriver driver = null;
private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
public WebDriver Brower_Invocation(String browser) {
	if(browser.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
		logger.info("Crome Browser Invoked");
	}
	else if (browser.equalsIgnoreCase("chrome")) {
		driver = new FirefoxDriver();
		logger.info("Firefox Browser Invoked");
	}
	else {
		System.out.println("Incorrect browser");
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	return driver;
}
public void switching_tab() {
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> itr=handles.iterator();
	String Parent_Window_ID = itr.next();
	String Child_Window_ID = itr.next();
	driver.switchTo().window(Child_Window_ID);
}
public void switching_to_orignal_tab() {
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> itr=handles.iterator();
	String Parent_Window_ID = itr.next();
	
	driver.switchTo().window(Parent_Window_ID);
}
}
