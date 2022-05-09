
package base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ProfilePage;
import utilities.Helper;
import utilities.Reporter;

public class TestBase {

	public static AppiumDriver driver;

	static String envRequired = utilities.LoadProperties.userData.getProperty("TestingEnvironment");

	public static void AndroidSetUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appActivity", "com.runtastic.android.activities.StartActivity");
		capabilities.setCapability("appPackage", "com.runtastic.android");

		switch (envRequired) {
			case "Testing":
				capabilities.setCapability("app",
						System.getProperty("user.dir") + "/application/Running.apk");
				break;
			case "Staging":
				capabilities.setCapability("app",
						System.getProperty("user.dir") + "/application/Running.apk");
			case "PreProd":
				capabilities.setCapability("app",
						System.getProperty("user.dir") + "/application/Running.apk");
				break;
		}

		capabilities.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getBinaryPath());
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
	}


	public static void tearDown() throws IOException{
		if (null != driver) {
			Reporter.stopRecording();
			driver.quit();
			Reporter.attachRecording();
		}
	}

	public static void logOutFromApp() {
		ProfilePage profilePageObj = new ProfilePage(driver);
		profilePageObj.logOutFromApp();
	}

	public static void setPerAndLogOutFromApp() {
		ProfilePage profilePageObj = new ProfilePage(driver);
		HomePage	homePageObject = new HomePage(driver);
		homePageObject.setPermissions();
		profilePageObj.logOutFromApp();
	}

	//////////////////////// take screenshot when test case failed and add it in the Screenshots folder ////////////////////////
	@AfterMethod(alwaysRun = true)
	public void screenShotOnFailure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenShot(driver, result.getName());
			Helper.addAttachmenetsToAllure( result.getName(), "Screenshots\\"+ result.getName()+ ".png");
		}
	}
}
