package page;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int generateRandomNumber(int boundnum) {
		Random rnd = new Random();
		int generateNum =rnd.nextInt(boundnum);
		 return generateNum;
		
	}
	
	public void selectFRomDropdown(WebElement element, String visibleText) {
		
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
				
	}
	public void WaitForElement(WebDriver driver, int waitTime, WebElement element) {
		
		WebDriverWait wait= new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
