package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Apptestchargestatus {

	@Test
	public void testmobileappbychargestatus() throws MalformedURLException 
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("automationName","UiAutomator1");
		caps.setCapability("platformName","Android");
		caps.setCapability("platformVersion","8.1.0");
		caps.setCapability("deviceName","Nexus5X");
		caps.setCapability("app","C:\\Users\\alaa.eldiddy\\Desktop\\Alex\\app-debug.apk");
		caps.setCapability("appPackage","com.electrometer.alex3");
		caps.setCapability("appActivity","com.electrometer.alex3.ui.Login.LoginActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		
		
		//Elements of signin page and its Assertions
				WebElement Signintext=driver.findElement(By.id("operator_id"));
				Signintext.sendKeys("HHU5");
				WebElement passtext=driver.findElement(By.id("password"));
				passtext.sendKeys("12345678");
				WebElement login=driver.findElement(By.id("loginBtn"));
				login.click();
				WebElement watermark=driver.findElement(By.id("watermark"));
				Assert.assertTrue(watermark.isDisplayed());
		
	
				WebElement chargestatusbtn=driver.findElement(By.id("statusBtn"));
				chargestatusbtn.click();
				WebElement chargeid=driver.findElement(By.id("orderIdET"));
				chargeid.sendKeys("70002312");
				WebElement checkbtn=driver.findElement(By.id("inquiryBtn"));
				checkbtn.click();
				
				//Assertion on data of customer
				WebElement customercode=driver.findElement(By.id("customerCodeTv"));
				WebElement customername=driver.findElement(By.id("customerNameTv"));
				WebElement operationid=driver.findElement(By.id("operationIdTv"));
				WebElement status=driver.findElement(By.id("statusTv"));
				
				Assert.assertEquals("Customer Code : null",customercode.getText());
				Assert.assertEquals("Customer Name : null",customername.getText());
				Assert.assertEquals("Operation Id : 70002312",operationid.getText());
				Assert.assertEquals("Charge Status : ",status.getText());
				
				
				
				
				
				
	}
	
	
	
	
}
