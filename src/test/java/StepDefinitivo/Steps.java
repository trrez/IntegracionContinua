package StepDefinitivo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;
	@Given("Abrir Chrome")
	public void abrir_Chrome() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("En este paso se abre google chrome");
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\tatia\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8081/Integracion/");
	}

	@When("ingresar Username {string} y Password {string}")
	public void ingresar_Username_y_Password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se ingresan las credenciales del usuario");
		driver.findElement(By.id("username")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
	}

	@Then("inicia sesion")
	public void inicia_sesion() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se inicia sesion con los datos ingresados desde el archivo MyTest.feature");
		driver.findElement(By.id("loginbtn")).click();
	}

}
