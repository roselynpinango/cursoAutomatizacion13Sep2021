package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaHome;
import paginas.PaginaLogin;

public class Laboratorio4 {
	WebDriver driver;
	String url = "http://automationpractice.com";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITLunes\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos para Login desde Excel")
	public void login(String correo, String contrasenia) {
		PaginaHome home = new PaginaHome(driver);
		home.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarLogin(correo, contrasenia);
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
	
	@DataProvider(name="Datos para Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[2][2];
		
		datos[0][0] = "correodeprueba1@mailinator.com";
		datos[0][1] = "FHDHFJD";
		
		datos[1][0] = "correodeprueba2@mailinator.com";
		datos[1][1] = "$&/ETR/E";
		
		return datos;
	}
	
	@DataProvider(name="Datos para Login desde Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionITLunes\\Datos\\datosLab4_E2.xlsx", "Hoja1");
	}
}
