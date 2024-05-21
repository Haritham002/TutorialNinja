package Test.tutorial.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReports=new ExtentReports();
		File extentReportFile= new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorial Ninja");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM//yyyy hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		Properties prop=new Properties();
		File PropFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\Test\\tutorialNinja\\Config\\Config.Properties");
		try {
		    FileInputStream fis=new FileInputStream(PropFile);
			prop.load(fis);
			} 
		catch (IOException e) {
				
				e.printStackTrace();
			}
		
		extentReports.setSystemInfo("Application URL",prop.getProperty("url"));
		extentReports.setSystemInfo("Browser Name",prop.getProperty("browserName"));
		extentReports.setSystemInfo("Valid Email",prop.getProperty("email"));
		extentReports.setSystemInfo("Valid password",prop.getProperty("password"));
		extentReports.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReports.setSystemInfo("user name",System.getProperty("user.name"));
		extentReports.setSystemInfo("java version",System.getProperty("java.version"));
		
		return extentReports;
		
		
		
		
		
		
	}
	

}
