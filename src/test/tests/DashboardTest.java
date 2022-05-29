package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DashboardTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://interview-prep-test.herokuapp.com/");
    }

    @Test(testName = "Enter new question button")
    public void test08(){
        //opening coding dashboard
        driver.findElement(By.xpath("//form[@class='form-inline']//button[text()='Coding']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Enter new question ']")).isEnabled());
    }
}
