package com.automation;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstUITestRefactor {

    public static final String baseURL = "https://github.com/";
    static WebDriver driver;


    @BeforeAll
    public static void beforeMethodStart() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
        @AfterAll
        public static void closeBrowserAfter(){
            driver.close();

        }




    @Test
    public void isUserNameCorrect() {

        //Arrange
        String user = "andrejs-ps";
        driver.get(baseURL+user);



        //Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();


        //Assert

        Assertions.assertEquals(user, actualUserName);



    }

    @Test
    public void clickMethod() {
        //Arrange

        String user = "andrejs-ps/";
        driver.get(baseURL + user);


        //Act
        String repository = ("automated-tests-in-java-with-fluent-interface-using-webdriver-selenium");
        WebElement repositoryLink = driver.findElement(By.linkText(repository));
        repositoryLink.click();
        String actualLink = driver.getCurrentUrl();

        //Assert

        Assertions.assertEquals(baseURL + user + repository, actualLink);




    }

    @Test
    public void countMethod() {


        //Act
        driver.get("https://github.com/andrejs-ps?tab=repositories");
       List<WebElement> repositoriesNumber =  driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));


        //Assert
    Assertions.assertEquals(6,repositoriesNumber.size());

    }
}