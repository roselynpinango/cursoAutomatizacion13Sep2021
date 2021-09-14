package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaHome;
import paginas.PaginaLogin;

public class Laboratorio3_E2 {
	WebDriver driver;
	String url = "http://automationpractice.com";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITLunes\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		PaginaHome home = new PaginaHome(driver);
		home.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarLogin("micorreo@correo.com.ar", "1q2w3e4r5t6y");
		login.hacerClicEnSignIn();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaHome home = new PaginaHome(driver);
		home.escribirPalabraABuscar("jeans");
		home.hacerBusqueda();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
