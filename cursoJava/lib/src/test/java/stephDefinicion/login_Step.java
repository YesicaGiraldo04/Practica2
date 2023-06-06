package stephDefinicion;

import static org.junit.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cursoJava.base_java;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_Step extends base_java {
	
	private WebDriver driver;
	
	//Alamacenamiento de localizadores 
	
	public By BTN_Login = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]");
	public By LBL_ErrorMessage = By.xpath("//p[contains(text(),'Invalid credentials')]");
	public By TXT_Username = By.name("username");
	public By TXT_Password = By.name("password");
	public By LBL_Required1 = By.xpath("//span[contains(text(),'Required')]");
	public By LBL_Required2 = By.xpath("//span[contains(text(),'Required')]");
	public By TXT_PageHome = By.xpath("//header/div[1]/div[1]");
	
	

	@Given("^Un usuario que ingresa al login$")
    public void un_usuario_que_ingresa_al_login() throws Throwable {
        
		driver = configuration();
    }

    @When("^El usuario no ingresa ninguna credencial$")
    public void el_usuario_no_ingresa_ninguna_credencial() throws Throwable {
        
    	Thread.sleep(3000);
    	driver.findElement(BTN_Login).click();
    }

    @Then("^La pagina mjuestra un mensaje de error indicando que el campo esta vacio$")
    public void la_pagina_mjuestra_un_mensaje_de_error_indicando_que_el_campo_esta_vacio() throws Throwable {
        
    	Thread.sleep(5000);
    	
    	assertTrue(driver.findElement(LBL_Required1).isDisplayed());
    	assertTrue(driver.findElement(LBL_Required2).isDisplayed());
    }
    
    
    @When("^El usuario ingresa credenciales invalidas$")
    public void el_usuario_ingresa_credenciales_invalidas() throws Throwable {
    	Thread.sleep(3000);
    	driver.findElement(TXT_Username).sendKeys("cvbhnj");
    	driver.findElement(TXT_Password).sendKeys("xfcgjh");
    	
        
    }

    @Then("^La pagina le muestra un mensaje de error indicando que las credenciales son invalidas$")
    public void la_pagina_le_muestra_un_mensaje_de_error_indicando_que_las_credenciales_son_invalidas() throws Throwable {
    	
    	assertTrue(driver.findElement(LBL_ErrorMessage).isDisplayed());
        
    }
    
    
    
    @When("^El usuario ingresa credenciales validas$")
    public void el_usuario_ingresa_credenciales_validas() throws Throwable {
        driver.findElement(TXT_Username).sendKeys("Admin");
        driver.findElement(TXT_Password).sendKeys("admin123");
    }

    @Then("^La pagina valida las credenciales e ingresa a la pagina principal$")
    public void la_pagina_valida_las_credenciales_e_ingresa_a_la_pagina_principal() throws Throwable {
    	
    	assertTrue(driver.findElement(BTN_Login).isDisplayed());
        
    }
    
    @When("^El usuario solo ingresa una credencial valida$")
    public void el_usuario_solo_ingresa_una_credencial_valida() throws Throwable {
        
    }

    @Then("^La pagina le muestra un mensaje de error indicando que ambos campos se deben llenar$")
    public void la_pagina_le_muestra_un_mensaje_de_error_indicando_que_ambos_campos_se_deben_llenar() throws Throwable {
        
    }
    

    @When("^El usuario clickea en Olvido su contraseña y llena los campos$")
    public void el_usuario_clickea_en_olvido_su_contrasea_y_llena_los_campos() throws Throwable {
        
    }

    @Then("^La pagina muestra un mensaje notificando el cambio$")
    public void la_pagina_muestra_un_mensaje_notificando_el_cambio() throws Throwable {
        
    }
	
	
	
	
	
	/*
    
	public By BTN_Login = By.id("login-button");
	public By TXT_Username = By.id("user-name");
	public By TXT_Password = By.id("password");
	public By LBL_EmptyUser = By.xpath("//h3[contains(text(), 'Epic sadface: Username is required')]");
	public By LBL_WrongCredentials = By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]");
	public By LBL_TextHome = By.xpath("//div[contains(text(), 'Swag Labs')]");
	
	
	 
	@Given("^Un usuario que ingresa al login$")
    public void un_usuario_que_ingresa_al_login() throws Throwable {
        driver = configuration();
    }

    @When("^El usuario no ingresa ninguna credencial$")
    public void el_usuario_no_ingresa_ninguna_credencial() throws Throwable {
    	
        driver.findElement(BTN_Login).click();
    }

    @Then("^La pagina muestra un mensaje de error indicando que el usuario esta vacio$")
    public void la_pagina_muestra_un_mensaje_de_error_indicando_que_el_usuario_esta_vacio() throws Throwable {
        
    	Thread.sleep(3000);
    	assertTrue(driver.findElement(LBL_EmptyUser).isDisplayed());
    }
    
    
    

    @When("^El usuario ingresa credenciales invalidas$")
    public void el_usuario_ingresa_credenciales_invalidas() throws Throwable {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(TXT_Username));
    	
        driver.findElement(TXT_Username).sendKeys("asdasd");
        driver.findElement(TXT_Password).sendKeys("asdasdas");
        driver.findElement(BTN_Login).click();
    }

    @Then("^La pagina le muestra un mensaje de error indicando que las credenciales son invalidas$")
    
    public void la_pagina_le_muestra_un_mensaje_de_error_indicando_que_las_credenciales_son_invalidas() throws Throwable {
     Thread.sleep(3000);   
    assertTrue(driver.findElement(LBL_WrongCredentials).isDisplayed());
    	
    }
    
    
    
    
    @When("^El usuario ingresa credenciales validas$")
    public void el_usuario_ingresa_credenciales_validas() throws Throwable {

        driver.findElement(TXT_Username).sendKeys("standard_user");
        driver.findElement(TXT_Password).sendKeys("secret_sauce");
        driver.findElement(BTN_Login).click();
    }

    @Then("^La pagina valida credenciales e ingresa a la pagina principal$")
    public void la_pagina_valida_credenciales_e_ingresa_a_la_pagina_principal() throws Throwable {
        

    	Thread.sleep(3000);
    	assertTrue(driver.findElement(LBL_TextHome).isDisplayed());
    	
    }
	
    
     */
	
	
	    @After
	    public void TearDown() {
	    
	    	driver.quit();
	    

	}
}