package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Helpers;

import javax.swing.plaf.TableHeaderUI;

import java.time.Duration;

import static tests.loginPage.loginAction;

public class openPage {
    public static String link;
    public static WebDriver driver;

    @BeforeTest
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        link = "https://www.saucedemo.com/";
    }
    private static void loginAction () {

        WebElement loginButtonCheckDisplayed = driver.findElement(By.cssSelector("*[data-test=\"login-button\"]"));

        if(loginButtonCheckDisplayed.isDisplayed()) {


            WebElement loginButton = driver.findElement(By.cssSelector("*[data-test=\"login-button\"]"));
            loginButton.click();
        }else{
            System.out.println("no login btton");
        }


    }
    @Test(priority = 1)
    public static void openPage(){
        driver.get(link);
        Assert.assertEquals(driver.getCurrentUrl(),link,"url didnt match");

    }
    @Test(priority =2)
    public static void autorizationFail() throws InterruptedException {
        Thread.sleep(3000);
        Helpers helper = new Helpers();
        helper.invalidAutorisationMethod(driver);
        loginAction();
        Thread.sleep(1000);

        if(driver.getPageSource().contains("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("error message is succesfull");
        }else {
            System.out.println("element invisible");
        }

        Helpers helpers = new Helpers();
        helpers.clearFields(driver);
        Thread.sleep(5000);


    }




    @AfterTest
    public static void tearDown(){
        driver.quit();
    }


}
