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
	
	ExcelReader exlReader = new ExcelReader("testData\\TF_TestData.xlsx");
	String userName = exlReader.getCellData("LoginInfo", "UserName", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);
	String name = exlReader.getCellData("AddContactInfo", "FullName", 2);
	String company = exlReader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlReader.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = exlReader.getCellData("AddContactInfo", "Phone", 2);
	String address = exlReader.getCellData("AddContactInfo", "Address", 2);
	String city = exlReader.getCellData("AddContactInfo", "City", 2);
	String state = exlReader.getCellData("AddContactInfo", "State", 2);
	String zip = exlReader.getCellData("AddContactInfo", "Zip", 2);
	String country = exlReader.getCellData("AddContactInfo", "Country", 2);
	
	@Test
	public void userShouldBeAbleToCreateNewCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboard();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.clickOnCustomerButton();
		addCustomer.clickOnAddCustomerButton();
		addCustomer.enterName(name);
		addCustomer.enterCompanyName(company);
		addCustomer.enterEmail(email);
		addCustomer.enterPhoneNumber(phoneNum);
		addCustomer.enterAddress(address);
		addCustomer.enterCity(city);
		addCustomer.enterState(state);
		addCustomer.enterZip(zip);
		addCustomer.enterCountryName(country);
		addCustomer.clickSubmitButton();
		
		addCustomer.clickListCustomersButton();
		addCustomer.verifyEnteredNameAndDelete();
		
		
		//BrowserFactory.tearDown();
		
	}

}
