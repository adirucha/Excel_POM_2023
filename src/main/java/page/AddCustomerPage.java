package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add Contact')]")
	WebElement ADD_CONTACT_HEADER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIPCODE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@id='summary']")
	WebElement SUMMARY_PROFILE_PAGE_ELEMENT;
	
	
	
	public void validateAddContactPage() {
		
	//	System.out.println("********************************" + ADD_CONTACT_HEADER.getText());
		Assert.assertTrue(ADD_CONTACT_HEADER.isDisplayed(), "AddContact Page not found!!");
	//	Assert.assertEquals(ADD_CONTACT_HEADER.getText(), "Add Contact", "Add Contact page not found");

	}

	public void enterFullName(String fullName) {

		FULLNAME_ELEMENT.sendKeys(fullName + generateRandomNumber(999));
	}

	public void selectFromCompany(String company) {
		selectFRomDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNumber(999) + email);

	}

	public void insertphoneNumber(String phoneNumber) {
		PHONE_ELEMENT.sendKeys(phoneNumber + generateRandomNumber(999));

	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {

		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {

		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {

		ZIPCODE_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String country) {

		selectFRomDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}

	public void saveButton() {

		SAVE_BUTTON_ELEMENT.click();
	}
	
	public void ValidateProfilePage() {
		
		
		WaitForElement(driver,5,SUMMARY_PROFILE_PAGE_ELEMENT);
		Assert.assertTrue(SUMMARY_PROFILE_PAGE_ELEMENT.isDisplayed(), "Profilepage not found!!");
		
	}


	//tbody/tr/td[3]
	////tbody/tr[2]/td[3] 
	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[3]";
	public void validateInsertedName() {
		for(int i=1; i<=5;i++) {
		String name= driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(name);
			
			
		}

		
	}
}
