package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaHome {
	WebDriver driver;
	
	// Elementos de la Página
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement txtBuscador;
	
	// Constructor
	public PaginaHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabraABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
