package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
//        
// Testataan jo tietokannassa olevaa käyttäjää oikealla ja väärällä salasanalla        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        System.out.println(driver.getPageSource());
//
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("elma");
//        
//        System.out.println(driver.getPageSource());
//
//
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("salasana1"); // oikea salasana
//        // element.sendKeys("salasana2"); väärä salasana
//        System.out.println(driver.getPageSource());
//
//        
//        element = driver.findElement(By.name("login"));
//        System.out.println(driver.getPageSource());
//
//        
//        element.submit();
//        System.out.println(driver.getPageSource());

// Testaan uuden käyttäjän luomista ja ulos kirjautumista
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        System.out.println(driver.getPageSource());
        
        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("salla"+r.nextInt(100000));
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana123");
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana123");
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("signup"));
        System.out.println(driver.getPageSource());
        
        element.submit();
        System.out.println(driver.getPageSource());
        
        sleep(3);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        System.out.println(driver.getPageSource());
        
        

        
        driver.quit();
    }
    
    private static void oikeaKayttajaKirjautuu(){
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
