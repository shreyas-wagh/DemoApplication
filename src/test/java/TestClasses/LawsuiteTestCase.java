package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LoginPages;
import Utility.BaseUtility;

public class LawsuiteTestCase {
	private WebDriver driver;	
	
	@BeforeMethod
	public void init() throws IOException {
		BaseUtility bu = new BaseUtility();
		driver = bu.startUp("ch", "https://www.accessibility.com/digital-lawsuits");
		driver.findElement(By.id("hs-eu-confirmation-button")).click();		
		
		}


	@Test()
	public void verifyText() {
		SoftAssert sa = new SoftAssert();
		LoginPages lp_obj = new LoginPages(driver);
		
		lp_obj.getDataInformation();		
		sa.assertTrue(lp_obj.Plaintiff_Text());
		
		sa.assertTrue(lp_obj.Defendant_Text());
		sa.assertAll();
		
	}
	
	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	
	
}