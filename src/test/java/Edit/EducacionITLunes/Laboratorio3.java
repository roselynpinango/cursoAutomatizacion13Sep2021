package Edit.EducacionITLunes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	File screen;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITLunes\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP02 - Buscar Palabra valida desde Chrome",priority=0)
	public void buscarPalabra() throws Exception {
		WebElement txtBuscador = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		txtBuscador.sendKeys("jean");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionITLunes\\Evidencias\\01_AntesDeBuscar.png"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionITLunes\\Evidencias\\02_DespuesDeBuscar.png"));
		
		Assert.assertNotEquals(url, driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "Search - My Store");
	}
	
	@Test(description="CP01 - Ir a Contact Us desde Chrome",priority=1)
	public void irAContactUs() {
		driver.findElement(By.linkText("Contact us")).click();
	}
	
	@Test(description="CP03 - Registrar Usuario",priority=2)
	public void registrarUsuario() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
		
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo11@correo.com.ar");
		
		driver.findElement(By.name("SubmitCreate")).click();
		
		wait = new WebDriverWait(driver, 10);
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
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
