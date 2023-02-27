package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("TestData\\2023-02-19--TF_TestData.xlsx");

	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);

	@Test

	public void userShouldBeAbleToAddCustomer() throws InterruptedException {

		driver = BrowserFactory.init();
		ExcelReader exlRead = new ExcelReader("TestData\\2023-02-19--TF_TestData.xlsx");

		String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
		String password = exlRead.getCellData("LoginInfo", "Password", 2);
		String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
		String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
		String email = exlRead.getCellData("AddContactInfo", "Email", 2);
		String phoneNumber = exlRead.getCellData("AddContactInfo", "Phone", 2);
		String address = exlRead.getCellData("AddContactInfo", "Address", 2);
		String city = exlRead.getCellData("AddContactInfo", "City", 2);
		String state = exlRead.getCellData("AddContactInfo", "State", 2);
		String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
		String country = exlRead.getCellData("AddContactInfo", "Country", 2);
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.clickSiginButton();

		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);

		dashboardpage.ValidateDashboardPage();
		dashboardpage.ClickcustomerMenuElement();
		dashboardpage.ClickAddCustomerElement();
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(500, 500));
		driver.manage().window().maximize();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.selectFromCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertphoneNumber(phoneNumber);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.saveButton();
		addCustomerPage.ValidateProfilePage();
		dashboardpage.clickListCustomerElement();
		addCustomerPage.validateInsertedName();
	}
}
