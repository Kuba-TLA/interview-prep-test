package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class DashboardTest extends BaseTest {

    @Test(testName = "Enter new question button")
    public void test08(){
        LoginPage loginPage = new LoginPage(getDriver());
        //login first
        loginPage.username.sendKeys("test@yahoo.com");
        //getDriver().findElement(By.name("email")).sendKeys("test@yahoo.com");
        getDriver().findElement(By.name("password")).sendKeys("test123");
        getDriver().findElement(By.xpath("//div[@class='container']/button")).click();
        //opening coding dashboard
        getDriver().findElement(By.xpath("//form[@class='form-inline']//button[text()='Coding']")).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Enter new question ']")).isEnabled());
    }
}
