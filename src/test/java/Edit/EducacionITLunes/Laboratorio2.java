package Edit.EducacionITLunes;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITLunes\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo12@correo.com.ar");
		
		driver.findElement(By.name("SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		WebElement radMr = driver.findElement(By.cssSelector("#id_gender1"));
		radMr.click();
		
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		txtFirstName.sendKeys("Julian");
		
		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByValue("18");
		
		WebElement chkNewsletter = driver.findElement(By.id("newsletter"));
		chkNewsletter.click();
		
		driver.findElement(By.name("customer_lastname")).sendKeys("Ramirez");
		
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4r5t");
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByIndex(2);
		
		Select years = new Select(driver.findElement(By.name("years")));
		years.selectByValue("1986");
		
		driver.findElement(By.id("address1")).sendKeys("123 calle st");
		
		driver.findElement(By.name("city")).sendKeys("Cordoba");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Arkansas");
		
		driver.findElement(By.id("postcode")).sendKeys("12345");
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("54765463746");
		
		WebElement txtAlias = driver.findElement(By.name("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Mi Casa");
		
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}
}
