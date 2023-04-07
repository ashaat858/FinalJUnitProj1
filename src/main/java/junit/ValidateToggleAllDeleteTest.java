package junit;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateToggleAllDeleteTest {

	WebDriver driver;
	static String  NewName = "AbdalNewNameADDED";

//	@FindBy(xpath = "//*[@id=\"todos-content\"]/form/ul")
//	List <WebElement> ElementCounts;
//	List<WebElement> CHECK_BOX = driver.findElements(By.xpath("//*[@type='checkbox']"));

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/107/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void ValidateRemoveAllListedAddedNamesWithToggleAll() {
//		WebElement TOGGLEBOX_CLICK_ALL_BOXES = driver.findElement(By.xpath("//input[@name='allbox']"));
		By TOGGLEBOX_CLICK_ALL_BOXES = By.xpath("//input[@name='allbox']");
		driver.findElement(TOGGLEBOX_CLICK_ALL_BOXES).click();
		
//		WebElement DELETE_BUTTON_TO_CLICK = driver.findElement(By.xpath("/html/body/div[3]/input[1]"));
		By DELETE_BUTTON_TO_CLICK = By.xpath("/html/body/div[3]/input[1]");
		driver.findElement(DELETE_BUTTON_TO_CLICK).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		WebElement INDEX_ADDED_NEW_NAME = driver.findElement(By.xpath("//*[@id=\\\"todos-content\\\"]/form/ul/li/a")) ;
//		By CHECKED_BOX_ITERATION = By.xpath("//*[@id=\"todos-content\"]/form/ul/li[0]/input");
//		String beforeXPath = "//*[@id='todos-content']/form/ul/li[";
//		String afterXPath = "]/input";
//		
//		//this of course not right 
//		for(int i = 0; i<6; i++) {
//			if (i!=0) {System.out.println(beforeXPath + i + afterXPath);
//		}
//		else {System.out.println("ALL CHECK BOXES HAVE BEEN DELETED!!");
//			};

//		 By ElementCounts = By.xpath("//*[@id=\"todos-content\"]/form/ul");
//		int afterdelete = CHECK_BOX.size();
//		afterdelete = 1;
//		Assert.assertEquals(CHECK_BOX.size(),afterdelete);
//				System.out.println("deleted all boxes successfully!");
		}
	
	

	@After
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}