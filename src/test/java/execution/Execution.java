package execution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CreateCustomer;
import pageObjects.SignIn;
import utilities.DataProviders;

public class Execution {
		public WebDriver driver;
		SignIn sp;
		CreateCustomer cp;
		@BeforeMethod
		public void setup() throws InterruptedException
		{	
			System.setProperty("webdriver.chrome.driver",".//Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			sp = new SignIn(driver);
			cp = new CreateCustomer(driver);
			driver.get("https://admin-demo.nopcommerce.com/login");
			driver.manage().window().maximize();
			sp.setEmail("admin@yourstore.com");
			sp.setPassword("admin");
			sp.clickSignin();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		@Test(dataProvider="Data", dataProviderClass=DataProviders.class)
		public void testCustomerCreation(String email, String pass, String fname, String lname, String gender, String company, String tax, String vendor, String comment) throws InterruptedException
		{
			cp.customersList();
			cp.customers();
			cp.addnewcustomer();
			cp.setEmail(email);
			cp.setPassword(pass);
			cp.setFirstname(fname);
			cp.setLastname(lname);
			cp.setGender(gender);
			cp.setCompany(company);
			cp.setTax(tax);
			cp.setVendor(vendor);
			cp.setActive();
			cp.setAdmincomment(comment);
			Thread.sleep(5000);
			cp.save();
			if(driver.getPageSource().contains("The new customer has been added successfully."))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		@AfterMethod
		public void unSet() throws InterruptedException
		{
			sp.clicLogout();
			driver.close();
			Thread.sleep(2000);
		}
	}
