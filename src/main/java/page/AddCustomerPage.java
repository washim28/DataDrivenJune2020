package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddCustomerPage extends BasePage{

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement USERNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHOME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using ="//*[@id='city']") WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using ="//*[@id='state']") WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using ="//*[@id='zip']") WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement CUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using ="//*[@id='submit']") WebElement SUBMIT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using ="//a[contains(text(), 'List Customers')]") WebElement LIST_CUSTOMER_BUTTON_LOCATOR;

	// Interactive Methods
	public void clickOnCustomerButton() {
		CUSTOMER_FIELD_LOCATOR.click();
	}

	public void clickOnAddCustomerButton() {
		waitForElement(driver, 3, ADD_CUSTOMER_FIELD_LOCATOR);
		ADD_CUSTOMER_FIELD_LOCATOR.click();
	}
	
	String enteredName;
	public void enterName(String name) {
		waitForElement(driver, 3, USERNAME_FIELD_LOCATOR);
		int randomNum = randomNumGenerator();
		enteredName = name + randomNum;
		USERNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}
	
	public void enterCompanyName(String company) {
		selectFromDropdown(COMPANY_FIELD_LOCATOR, company);
	}
	
	public void enterEmail(String email) {
		int randomNum = randomNumGenerator();
		EMAIL_FIELD_LOCATOR.sendKeys(randomNum + email);
	}
	
	public void enterPhoneNumber(String phoneNum) {
		int randomNum = randomNumGenerator();
		PHOME_FIELD_LOCATOR.sendKeys(phoneNum + randomNum);
	}
	
	public void enterAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}
	
	public void enterCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}
	
	public void enterState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}
	
	public void enterZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}
	

	public void enterCountryName(String country) {
		selectFromDropdown(CUNTRY_FIELD_LOCATOR, country);
	}
	
	public void clickSubmitButton() {
		SUBMIT_BUTTON_LOCATOR.click();
	}
	
	public void clickListCustomersButton() throws InterruptedException {
		Thread.sleep(3000);
		LIST_CUSTOMER_BUTTON_LOCATOR.click();
	}
	
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	
	public void verifyEnteredNameAndDelete() {
		for(int i = 1; i <= 5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//System.out.println("======" + name);
			/*Assert.assertEquals(name, enteredName, "Entered name dosen't exists!!");
			break;*/
			
			if(name.contains(enteredName)) {
				System.out.println("Entered name exist.");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
			}
			
		}
	}

}
