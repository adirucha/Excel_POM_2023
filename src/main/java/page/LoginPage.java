package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	
	//making connection of driver from loginpage to logintest(constructor)
	public  LoginPage( WebDriver driver) {
		this.driver = driver;
		
	}
	//Elements
	@FindBy(how = How.XPATH,using= "//input[@id='username'] ")WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH,using= "//input[@id='password'] ")WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH,using= "//button[@name='login'] ")WebElement SIGNIN_BUTTON_ELEMENT;
	
	
	//Interactable methods

	public void enterUsername(String userName) {
		
		USERNAME_ELEMENT.sendKeys(userName);
		}
	public void enterPassword(String passWord) {
		PASSWORD_ELEMENT.sendKeys(passWord);
		
	}
	public void clickSiginButton() {
		SIGNIN_BUTTON_ELEMENT.click();
		
	}
}
