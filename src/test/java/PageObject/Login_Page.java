package PageObject;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import junit.framework.Assert;

public class Login_Page {
	public WebDriver driver;
	String URL;
	private By LogoImage = By.xpath("//img[@class='logo img-responsive']");
	private By Product_Category = By.xpath("//*[@id=\"block_top_menu\"]/ul/li");
	private static final Logger logger = LogManager.getLogger(Login_Page.class);
	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}
	public void NavigatedToHomePage(String URL) {
		driver.get(URL);
		logger.info("browser opened WebPage "+URL);
				
	}
	public String Current_URL() {
		String actualURL = driver.getCurrentUrl();
		logger.info("Current URL "+ actualURL);
		return actualURL;
	}
	public void LogoValidation(){
		if(driver.findElement(LogoImage).isDisplayed()){
          Assert.assertTrue(true);
          logger.info("Logo is displayed on the page");
	}else {
		Assert.fail("Logo is not displayed");
		logger.info("Logo is not  displayed on the page");
	}
	
}
	public int Logowidth() {
		int width = driver.findElement(LogoImage).getSize().width;
		return width;
	 }
	public int LogoHeight() {
		int Height = driver.findElement(LogoImage).getSize().height;
		return Height;
	}
	public Integer Product_Cat() {
		Integer Actual_Count = driver.findElements(Product_Category).size();
		return Actual_Count;
	}
	public void ProductName(String Product) {
		List <WebElement>  list = driver.findElements(Product_Category);
		int size = list.size();
		for(int i=0; i<size; i++ ) {
			if(Product.equals(list.get(i).getText())) {
				Assert.assertTrue(true);
				logger.info("Product Category Matched with Expected ");
			}
		}
	}
}
