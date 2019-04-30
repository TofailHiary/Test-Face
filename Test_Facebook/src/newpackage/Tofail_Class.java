package newpackage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class Tofail_Class {
	public WebDriver driver ;
//uncomment the firefox driver ruunner in case you need to test over firefox or chrome driver in case you use chrome 
	@Before
	@Given ("Open Browser")
	public  void testFace() {
        
    	//System.setProperty("webdriver.firefox.marionette","Users⁩\\⁨apple⁩\\⁨Desktop\\geckodriver⁩");
		 //driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","//Users//apple//Desktop//chromedriver");
		 driver = new ChromeDriver();
	}
	@Test
	@When ("Open Facebook and check the background and title")
	public  void openFacebook(){
        String baseUrl = "https://www.facebook.com/";
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = "";
    
        
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        WebElement backGroundColor = driver.findElement(By.tagName("body"));
        WebElement login = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        WebElement logina = driver.findElement(By.id("loginbutton"));
        /*;
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        try {
        	//this code to check the page we have opened is right page 
        	if (actualTitle.contentEquals(expectedTitle)){
        			System.out.println("Title has passed");
        		} else {
        			System.out.println("Title has failed");
        		}
        	
        	//this code to check background is displayed or not 
        	if (backGroundColor.isDisplayed()) {
        		System.out.println("Body is displayed");
        	} else {
        		System.out.println("Body is hidden");
        	}
        	//this code to check background color 
        	
        	if (backGroundColor.getCssValue("background-color").contentEquals("rgba(0, 0, 0, 0)")) {   
        		System.out.println("Color is white");
        	} else {
        		System.out.println("Fail");
        	}
   
        	
        
        // if you wan to login tou can put valid Credentials 
        login.sendKeys("put your phone number or email"); //  you have to put your email or phone number 
        pass.sendKeys("put your password here"); // you have to put your password here 
        logina.click();
        }
        
        catch (Exception ex) {
        	System.out.println("Error is:" + ex.toString());
        }
	}
    	@After
    	@Then ("Close Browser")
    	public  void CloseBrowser() {
        
        //close Fire fox
        
        driver.close();
    	}
    }


