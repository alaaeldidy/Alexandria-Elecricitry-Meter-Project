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


public class Apptestbycharge {

	
	
	@Test
	public void testmobileappbycharge() throws MalformedURLException 
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
		
	
		//charge and its Assertion
		WebElement charge=driver.findElement(By.id("chargeBtn"));
		charge.click();
		WebElement entercstnoassert=driver.findElement(By.className("android.widget.TextView"));
		Assert.assertEquals("please enter customer number",entercstnoassert.getText());
		
		
		WebElement customerno=driver.findElement(By.id("codeET"));
		customerno.sendKeys("70002312");
		WebElement send=driver.findElement(By.id("inquiryBtn"));
		send.click();
		
		//Assertions
		WebElement logo=driver.findElement(By.id("logo1"));
		Assert.assertTrue(logo.isDisplayed());
		WebElement custmercode=driver.findElement(By.id("customerCodeTv"));
		Assert.assertEquals("Customer Code :70002312",custmercode.getText());
		WebElement customerName=driver.findElement(By.id("customerNameTv"));
		Assert.assertEquals("Customer Name :GPRS 1",customerName.getText());
		WebElement meterid=driver.findElement(By.id("meterIdTv"));
		Assert.assertEquals("Meter Id :70002312",meterid.getText());
		
		
		WebElement amount=driver.findElement(By.id("amountET"));
		amount.sendKeys("40");
		WebElement chargebtn=driver.findElement(By.id("chargeBtn"));
		chargebtn.click();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		//Assert
		WebElement paidamount=driver.findElement(By.id("paidAmount"));
		Assert.assertEquals("40.0",paidamount.getText());
		
		}	
	
	
	

	
	
	
}
