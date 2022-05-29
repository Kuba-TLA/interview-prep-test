package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(testName = "Wrong login info message")
    public void test07(){
        getDriver().findElement(By.name("email")).sendKeys("test@yahoo.commm");
        getDriver().findElement(By.name("password")).sendKeys("test123");
        getDriver().findElement(By.xpath("//div[@class='container']/button")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//*[text()='Incorrect username/password']")).isDisplayed());
    }
}
