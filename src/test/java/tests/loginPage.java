package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Helpers;

import java.time.Duration;

public class loginPage {
    static WebDriver driver;
    public static String link;
    public static WebDriverWait w;


    @BeforeTest
    public  void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        link = "https://www.saucedemo.com/";
        driver.get(link);
    }
    public static void loginAction () {


        // w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[data-test=\"login-button\"]")));
        w = new WebDriverWait(driver, Duration.ofMillis(5000L));
        w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[data-test=\"login-button\"]")));

        WebElement loginButton = driver.findElement(By.cssSelector("*[data-test=\"login-button\"]"));
        loginButton.click();


    }





    @Test(priority = 3)
    public static void authorization() throws InterruptedException {

        Helpers helpers = new Helpers();
        helpers.avtorizaciislogika(driver);
        loginAction();

    }

    @Test(priority = 4)
    public static void addToCart() throws InterruptedException {
         w = new WebDriverWait(driver, Duration.ofMillis(5000L));
         w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")));


        //Thread.sleep(4000);
        WebElement addToCartBtn = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCartBtn.click();
    }

    @Test(priority = 5)
    public static void removeFromCart() throws  Exception{

        String buttonXpath  = "//*[@id=\"remove-sauce-labs-backpack\"]";

        w = new WebDriverWait(driver, Duration.ofMillis(5000L));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXpath)));

        WebElement removeBtn = driver.findElement(By.xpath(buttonXpath));
        removeBtn.click();

    }

    @AfterTest
    public static void tearDown(){
        driver.quit();

    }

}
