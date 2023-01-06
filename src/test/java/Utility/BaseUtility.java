package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseUtility {

	public WebDriver startUp(String bName, String url)
	{

		WebDriver driver = null;

		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome"))
		{			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-notifications");
			driver= new ChromeDriver(options);
			
		}else if(bName.equalsIgnoreCase("edge")) 
		{

			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}else if(bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("firefox")) 
		{

			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else
		{
			System.out.println("Invalid browser name !!!");
		}

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();

		return driver;

	}


}

