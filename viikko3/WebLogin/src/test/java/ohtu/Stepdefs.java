package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("nonexistent username {string} and password {string} are given")
    public void nonexsistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }     

    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernamePasswordAndConfirmationAreGiven(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("a nonvalid username {string} and password {string} and matching password confirmation are entered")
    public void nonvalidUsernamePasswordAndConfirmationAreGiven(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("a valid username {string} and a short password {string} and matching password confirmation are entered")
    public void validUsernameShortPasswordAndConfirmationAreGiven(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("a valid username {string} and a only-letter password {string} and matching password confirmation are entered")
    public void validUsernameLetterPasswordAndConfirmationAreGiven(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("a valid username {string} and password {string} and wrong confirmation {string} are entered")
    public void validUsernamePasswordAndWrongConfirmationAreGiven(String username, String password, String confirmation) {
        signUpWith(username, password, confirmation);
    }
    
    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
        pageHasContent("continue to application mainpage");
    }
    
    @Then("user is not created and error {string} is reported")
    public void newUserIsCreated(String error) {
        pageHasContent("Create username and give password");
        pageHasContent(error);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void signUpWith(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
