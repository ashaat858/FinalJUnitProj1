package junit;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckBoxAddDeleteTest {

	WebDriver driver;
	static String  NewName = "AbdalNewNameADDED";
	int generateNum;
	


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
	public void toggleTest() {
		

		
//		WebElement TOGGLEBOX_CLICK_ALL_BOXES = driver.findElement(By.xpath("//input[@name='allbox']"));
		By TOGGLEBOX_CLICK_ALL_BOXES = By.xpath("//input[@name='allbox']");
//		WebElement INPUT_NAME_CREATE = driver.findElement(By.xpath("//input[@name='data']"));
		By INPUT_NAME_CREATE = By.xpath("//input[@name='data']");
//		WebElement ADD_NAME_BUTTON = driver.findElement(By.xpath("//input[@value='Add']"));
		By ADD_NAME_BUTTON = By.xpath("//input[@value='Add']");

//		WebElement INDEX_ADDED_NEW_NAME = driver.findElement(By.xpath("//*[@id=\\\"todos-content\\\"]/form/ul/li/a")) ;
		By INDEX_ADDED_NEW_NAME = By.xpath("//*[@id=\\\"todos-content\\\"]/form/ul/li/a");

		driver.findElement(TOGGLEBOX_CLICK_ALL_BOXES).click();
	}
		

	public void assertionOnTggleBoxClick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		List<WebElement> mycheckBoxAssert = driver.findElements(By.xpath("//*[@type='checkbox']"));

		for (int i = 0; i < mycheckBoxAssert.size(); i++) {
			System.out.println(
					"attribut value Selected of Check-box is : " + mycheckBoxAssert.get(i).getAttribute("selected"));

			if (mycheckBoxAssert.get(i).getAttribute("selected").equals("null")) {

				mycheckBoxAssert.get(i).click();
			}

		}
	}
	public void clickOnAddedNewNameFromListToDelete () {
//		WebElement ADDED_NEW_NAME_IN_LIST = driver.findElement(By.xpath("//*[contains(text(),'AbdalNewNameADDED')]"));
		By ADDED_NEW_NAME_IN_LIST = By.xpath("//*[contains(text(),'AbdalNewNameADDED')]");

		
		driver.findElement(ADDED_NEW_NAME_IN_LIST).click();
	}
	public void clickOnRemoveButtonToDeleteAddedNewName() {
//		WebElement DELETE_BUTTON_TO_CLICK = driver.findElement(By.xpath("/html/body/div[3]/input[1]"));
		By DELETE_BUTTON_TO_CLICK = By.xpath("/html/body/div[3]/input[1]");
		driver.findElement(DELETE_BUTTON_TO_CLICK).click();
	}
	public void assertOnRemovingNewName() {
		Assert.assertEquals(NewName, null);
	}

	@After
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}