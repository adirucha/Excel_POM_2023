package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("TestData\\2023-02-19--TF_TestData.xlsx");
	
	
	String userName= exlRead.getCellData("LoginInfo", "UserName", 2);
	String password=exlRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() throws InterruptedException {
		
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.clickSiginButton();
		
		DashboardPage dashboardpage= PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardpage.ValidateDashboardPage();
		dashboardpage.ClickcustomerMenuElement();
		dashboardpage.ClickAddCustomerElement();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage();
		
		BrowserFactory.teardown();
		
		
		
		 }

}
