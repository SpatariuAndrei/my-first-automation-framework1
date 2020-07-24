package com.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.print.DocFlavor;
import java.util.concurrent.TimeUnit;

public class FirstUITest {

    @Test
    public void isUserNameCorrect(){

        //Arrange
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String user = "andrejs-ps";
        driver.get("https://github.com/" + user);




        //Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();



        //Assert

        Assertions.assertEquals(user,actualUserName);
        driver.close();



    }
    @Test
    public void clickMethod(){
        //Arrange
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String user = "andrejs-ps/";
        driver.get("https://github.com/" + user);


        //Act
        String repository = ("automated-tests-in-java-with-fluent-interface-using-webdriver-selenium");
        WebElement repositoryLink =  driver.findElement(By.linkText(repository));
        repositoryLink.click();
        String actualLink = driver.getCurrentUrl();

        //Assert

        Assertions.assertEquals("https://github.com/" + user+repository,actualLink);

        driver.close();


    }

}
