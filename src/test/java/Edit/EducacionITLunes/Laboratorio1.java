package Edit.EducacionITLunes;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Laboratorio1 {
	/**
	 * Método para abrir un navegador Chrome y 
	 * hacer una busqueda en AutomationPractice.com
	 */
	@Test
	public void abrirPaginaChrome() {
		// Paso 1: Indicar la ruta del driver 
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITLunes\\Drivers\\chromedriver.exe");
		
		// Paso 2: Tomar control del navegador utilizando el driver respectivo
		WebDriver driver = new ChromeDriver();
		
		// Paso 3: Abrir la pagina AutomationPractice.com, maximizar la ventana y limpiar las cookies
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Paso 4: Ingresar un valor en el campo y hacer la búsqueda correspondiente
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		//driver.close();	
	}
	
	/**
	 * Método para abrir un navegador Firefox y 
	 * hacer una busqueda en AutomationPractice.com
	 */
	@Test
	public void abrirPaginaFirefox() {
		// Paso 1: Indicar la ruta del driver 
		System.setProperty("webdriver.gecko.driver", "..\\EducacionITLunes\\Drivers\\geckodriver.exe");
		
		// Paso 2: Tomar control del navegador utilizando el driver respectivo
		WebDriver driver = new FirefoxDriver();
		
		// Paso 3: Abrir la pagina AutomationPractice.com, maximizar la ventana y limpiar las cookies
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Paso 4: Ingresar un valor en el campo y hacer la búsqueda correspondiente
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		//driver.close();	
	}
	
	/**
	 * Método para abrir un navegador Chrome incognito  y 
	 * hacer una busqueda en AutomationPractice.com
	 */
	@Test
	public void abrirPaginaChromeIncognito() {
		// Paso 1: Indicar la ruta del driver 
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITLunes\\Drivers\\chromedriver.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        
		// Paso 2: Tomar control del navegador utilizando el driver respectivo
		WebDriver driver = new ChromeDriver(options);
		
		// Paso 3: Abrir la pagina AutomationPractice.com, maximizar la ventana y limpiar las cookies
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Paso 4: Ingresar un valor en el campo y hacer la búsqueda correspondiente
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		//driver.close();	
	}
}
