package Test.tutorialNinjaBaseClass;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
	public Properties prop;
	
	public void loadPropertiesFile()
	{
         prop=new Properties();
		File PropFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\Test\\tutorialNinja\\Config\\Config.Properties");
		try {
		    FileInputStream fis=new FileInputStream(PropFile);
			prop.load(fis);
			} 
		catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
	}
	
	
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}

}
