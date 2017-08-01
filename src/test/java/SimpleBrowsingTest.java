import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleBrowsingTest {
	
	private static WebDriver driver;
	
	private static String rootUrl="https://www.migayo.com";
	
	private static String[] textInHome = {
			"Buscando la belleza en el equilibrio y en los detalles",
			"Después de 18 años juntos y un hijo Matteo y yo decidimos casarnos",
			"Cuento historias a través de las joyas",
			"¿Quieres que contemos juntos la vuestra?",
			"Con las joyas a medida, alianzas, anillos de pedida o gemas heredadas"
	};
	
	private static String joyasAMedidaUrl="/joyas-a-medida/";
	
	private static String[] textInJoyasAMedida = {
			"Las joyas a medida de Migayo buscan transmitir un sentimiento",
			"Su simbolismo es importante, llevan una historia detrás que se cuenta a través de la joya.",
			"Anillo de pedida oro rosa con ópalo",
			"Anillo de pedida minimal",
			"A medida: Pendientes con esmeraldas"
	};
	
	
	
	@BeforeClass
    public static void openBrowser(){
		// Tested with gecko driver v0.18.0
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 
	
	@Test
	public void visitHome(){
		// And now use this to visit Google
        driver.get(rootUrl);
        
        // Asserting expected text
        for (String text : textInHome){
        	Assert.assertTrue(driver.getPageSource().contains(text));
        }
       
	}
	
	@Test
	public void visitJoyasAMedida(){
		driver.get(rootUrl + joyasAMedidaUrl);
		
		// Asserting expected text
        for (String text : textInJoyasAMedida){
        	Assert.assertTrue(driver.getPageSource().contains(text));
        }
		
	}
	
	@AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
}
