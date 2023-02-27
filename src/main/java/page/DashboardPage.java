package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;
	
//WEBELEMENTS
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Dashboard')]")WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Customers')]")WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Customer')]")WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'List Customers')]")WebElement LIST_CUSTOMER_ELEMENT;
	

	//INTERACTABLE METHODS
	public void ValidateDashboardPage() {
		Assert.assertTrue(DASHBOARD_HEADER_ELEMENT.isDisplayed(), "Dashboard Page Not found!!");
	}
	
	public void ClickcustomerMenuElement() {
		CUSTOMER_MENU_ELEMENT.click();
		
	}
	public void ClickAddCustomerElement() {
		ADD_CUSTOMER_ELEMENT.click();
		
	}
	public void clickListCustomerElement() {
		LIST_CUSTOMER_ELEMENT.click();
		
	}
	




}
