package org.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class StepDefinitions  {

    public WebDriver driver;

    public static final String CHROME_DRIVER_EXE_PROPERTY = "webdriver.chrome.driver";
    @Given("user navigate to Login page {string}")
    public void user_navigate_to_login_page(String Url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @When("user enter username {string} and password {string}")
    public void user_enter_username_and_password(String UserName, String Password) throws InterruptedException {
        WebElement Username = driver.findElement(By.name("user-name"));
        Username.sendKeys(UserName);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(Password);

    }

    @When("click login button")
    public void click_login_button() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println("Clicking login button");
    }
    @Then("user can find the title {string}")
    public void user_can_find_the_title(String expected) throws InterruptedException {
            String Actual = driver.getTitle();
             String Expected = "Swag Labs";
           assertEquals(Expected,Actual);
             System.out.println("The page title has been successfully verified");
             System.out.println("User logged in successfully");
        }
    @Then("select the dropdown to price high to Low")
    public void select_the_dropdown_to_price_high_to_low() throws InterruptedException {
        WebElement productSort= driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
        Select select = new Select(productSort);
        select.selectByValue("hilo");


    }
    @Then("add the selected highest price item to the cart.")
    public void add_the_selected_highest_price_item_to_the_cart() {
        WebElement addToCart= driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
        addToCart.click();
    }
    @Then("click the cart")
    public void click_the_cart() throws InterruptedException {
        WebElement shoppingCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        shoppingCart.click();
        System.out.println("Clicking login button");

    }


    @Then("user can be seeing the checkout")
    public void user_can_be_seeing_the_checkout() throws InterruptedException {
        WebElement expected = driver.findElement(By.name("checkout"));
        String expt = expected.getText();
        String Actual = "Checkout";
        assertEquals(expt, Actual);
        System.out.println("User add the Highest price Product to Chart");
        driver.quit();

    }

}
