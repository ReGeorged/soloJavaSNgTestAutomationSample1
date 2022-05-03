package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {




    public  void avtorizaciislogika(WebDriver driver) {
        WebElement loginUserField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement loginPwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));


        String correctUsername = "standard_user";
        String correctPassword = "secret_sauce";
        loginPwordField.sendKeys(correctPassword);
        loginUserField.sendKeys(correctUsername);


    }
    public  void invalidAutorisationMethod(WebDriver driver) {
        WebElement loginUserField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement loginPwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        String incorrectPassword = "aaa";
        String incorrectUsername ="aaaaaa";

        loginPwordField.sendKeys(incorrectPassword);
        loginUserField.sendKeys(incorrectUsername);


    }
    public  void clearFields(WebDriver driver) {
        WebElement loginUserField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement loginPwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        loginPwordField.clear();
        loginUserField.clear();


    }

}
