package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	WebDriver driver;
	
	// Elementos
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(css="#passwd")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnSignIn;
	
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void completarLogin(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnSignIn() {
		btnSignIn.click();
	}
}
