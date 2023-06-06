package cursoJava;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {
	
	private WebDriver driver; //Instancia del Webdriver para poder interactuar con navegador
	
	@Before
	public void configuration() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions(); //Instanciamos las opciones (Creamos la lista de)
		
		options.addArguments("--incognito"); //Agregamos las opciones
		
		driver = new ChromeDriver(options); //Le especificamos que navegador vamos a utilizar
		
		driver.manage().window().maximize(); //Va a maximizar la ventana
	
		driver.get("https://www.google.com/");
		
	}
	
	
	 @Test
	public void buscarPalabra() throws InterruptedException {
		
		//Localizamos el boton "Buscar con Google" con Xpath
		WebElement BTN_SearchByGoogle = driver.findElement(By.name("btnK"));
		
		//Localizamos el Input de la tabla de búsqueda con el identificador
		WebElement TXT_SearchBar = driver.findElement(By.id("APjFqb"));
	
		TXT_SearchBar.sendKeys("YouTube"); //Escribimos Youtube en la barra
		Thread.sleep(2000); //Esperamos 2 segundos
		BTN_SearchByGoogle.click(); //Damos click en el botón buscar
		
		
		assertTrue(driver.getTitle().contains("YouTube"));
		
	}

	
	
	@Test
	public void test2() throws InterruptedException {
		
		String[] listadePalabrasRandom = {"perro", "gato", "auto", "bicicleta"};
		
		Random rand = new Random();
		int numeroRandom = rand.nextInt(listadePalabrasRandom.length);
		String palabra = listadePalabrasRandom[numeroRandom];
		
		//Localizamos el boton "Buscar con Google" con Xpath
		WebElement BTN_SearchByGoogle = driver.findElement(By.name("btnK"));
		
		//Localizamos el Input de la tabla de búsqueda con el identificador
		WebElement TXT_SearchBar = driver.findElement(By.id("APjFqb"));
			
		
		TXT_SearchBar.sendKeys(palabra);
		Thread.sleep(2000);
		BTN_SearchByGoogle.click();
		
		WebElement TXT_Search = driver.findElement(By.name("q"));
		assertEquals(palabra, TXT_SearchBar.getAttribute("value"));
		
	}
	
	
	
	
	/*
	 Feature: Logear en el sistema
	 
	 Scenario: Loguear sin credenciales
	 Given Usuario que ingresa al login
	 When Usuario no ingresa ninguna credencial
	 Then La maquina muesra un mensaje de error indicando que el mensaje este vacío
	 
	 Scenario: Logear concredenciales
	 Given Un usuario se dirige al login
	 When El usuario ingresa credenciales invalidas
	 Then La pagina le muestra un mensaje de error indicando que las credenciales son invalidas
	 
	 
	 Scenario: Loguear con credenciales validas
	 Given El usuario ingresa al login
	 When El usuario ingresa credenciales válidas
	 Then La pagina válida credenciales e ingresa a la pagina principal
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 */
	
	
	
	@After
	public void shutDown() throws InterruptedException{
		
		Thread.sleep(5000); //Espera cinco segundos
		driver.quit(); //Cerar el navegador y el proceso
	}
	

}
