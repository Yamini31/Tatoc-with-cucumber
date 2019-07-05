package StepDefinations;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

     WebDriver driver;
     String colorofbox2=null;
     
@Given("^Open Google Chrome and Visit Tatoc$")
public void open_Google_Chrome_and_Visit_Tatoc() throws Throwable {
	System.setProperty("webdriver.chrome.Driver", "/home/qainfotech/Downloads/chromedriver");
	 driver=new ChromeDriver();
	
	 driver.get("http://10.0.1.86/tatoc");
	 driver.manage().window().maximize();
	 Thread.sleep(2000);
}

@When("^Click on basic course$")
public void click_on_basic_course() throws Throwable {
	 
	 driver.findElement(By.linkText("Basic Course")).click();
	 Thread.sleep(2000);
	
}

@Then("^Verify the click$")
public void verify_the_click() throws Throwable {
   
	String heading=driver.findElement(By.xpath("//h1")).getText();
String head="Grid Gate";
	if(heading.equals(head))
	{
		System.out.print("Basic Course is Selected");
	}
}



@When("^click on Greeen box$")
public void click_on_Greeen_box() throws Throwable {
    
	driver.findElement(By.xpath("//div[@class=\"greenbox\"]")).click();
	 Thread.sleep(2000);
 
}

@Then("^Switch the frame$")
public void switch_the_frame() throws Throwable {
   
	 driver.switchTo().frame("main");
}


@Then("^check for color of the box$")
public void check_for_color_of_the_box() throws Throwable {
 
	
	 String colorofbox1=driver.findElement(By.id("answer")).getAttribute("class");
	 System.out.print(colorofbox1);
    
	 
	 do
	 {
		 driver.findElement(By.linkText("Repaint Box 2")).click();
		 driver.switchTo().frame("child");
		 colorofbox2=driver.findElement(By.id("answer")).getAttribute("class");
		 System.out.println(colorofbox2);
		 driver.switchTo().parentFrame();
		 
		
		 
    }while(!(colorofbox1.equals(colorofbox2)));
	
	
	
}

@Then("^Click on Proceed$")
public void click_on_Proceed() throws Throwable {

	Thread.sleep(2000);

	 driver.findElement(By.xpath("//a[@onclick=\"gonext();\"]")).click();
	 Thread.sleep(2000);
}

	

@When("^Drag and drop Successful$")
public void drag_and_drop_Successful() throws Throwable {
	 WebElement drag=driver.findElement(By.cssSelector("div#dragbox"));
	 WebElement drop=driver.findElement(By.cssSelector("div#dropbox"));
	 Actions a = new Actions(driver);
	 a.dragAndDrop(drag,drop).build().perform();
	

	
}

@Then("^Click on Proceed button$")
public void click_on_Proceed_button() throws Throwable {
	 driver.findElement(By.xpath("//a[@onclick=\"gonext();\"]")).click();	
	 Thread.sleep(1000);
}

@When("^launch pop up window$")
public void launch_pop_up_window() throws Throwable {
 
	 driver.findElement(By.linkText("Launch Popup Window")).click();	
	 Thread.sleep(1000);

	
}

@Then("^Enter Details$")
public void enter_Details() throws Throwable {
	  String MainWindow=driver.getWindowHandle();		
		
	    Set<String> s1=driver.getWindowHandles();		
      Iterator<String> i1=s1.iterator();		

      while(i1.hasNext())			
      {		
          String ChildWindow=i1.next();		
          		
          if(!MainWindow.equalsIgnoreCase(ChildWindow))			
          {    		
               
                  // Switching to Child window
                driver.switchTo().window(ChildWindow);	
      
    	 driver.findElement(By.cssSelector("input#name")).sendKeys("yaminigupta");
	      Thread.sleep(3000);
	       driver.findElement(By.cssSelector("input#submit")).click();
}
          
          }
      driver.switchTo().window(MainWindow);
      
}

@Then("^Press Submit$")
public void press_Submit() throws Throwable {
   
     driver.findElement(By.xpath("//a[@onclick=\"gonext();\"]")).click();	
		 Thread.sleep(1000);
		 
}

@When("^Token is Generated$")
public void token_is_Generated() throws Throwable {
	driver.findElement(By.linkText("Generate Token")).click();	
	 Thread.sleep(1000);
}


@Then("^Cookie is generated$")
public void cookie_is_generated() throws Throwable {
	 String token =driver.findElement(By.id("token")).getText();
		System.out.println(token);
		
		
		Cookie name =new Cookie("Token",token.split(": ")[1]);
		driver.manage().addCookie(name);
		
		Set<org.openqa.selenium.Cookie> cookiesList =  driver.manage().getCookies();
		for(Cookie getcookies :cookiesList) {
		    System.out.println(getcookies );
		}
}



@Then("^Proceed$")
public void proceed() throws Throwable {
	driver.findElement(By.linkText("Proceed")).click();
	

}


}
