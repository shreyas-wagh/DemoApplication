package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseUtility;

public class LoginPages {
	private  WebDriver driver;
	BaseUtility bu = new BaseUtility();
	@FindBy(className="equal_content")
	private WebElement contentTest;

	@FindBy(className="next-link")
	private WebElement nextbutton;

//=========================================================================

	public LoginPages(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//==========================================================================

	public boolean Plaintiff_Text() {
		String text = contentTest.getText();
		return text.contains("Plaintiff");

	}

	public boolean Defendant_Text() {
		String text = contentTest.getText();
		return text.contains("Defendant");
	}


	public void getDataInformation() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", nextbutton);
		
	}

//==========================================================================

}
