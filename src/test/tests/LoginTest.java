package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://interview-prep-test.herokuapp.com/");
    }

    @Test(testName = "Wrong login info message")
    public void test07(){
        driver.findElement(By.name("email")).sendKeys("test@yahoo.commm");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.xpath("//div[@class='container']/button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Incorrect username/password']")).isDisplayed());
    }
}
