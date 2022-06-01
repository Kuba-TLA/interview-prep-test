package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void localSetUp(){
        loginPage = new LoginPage(getDriver());
    }

    @Test(testName = "Wrong login info message")
    public void test07(){
        loginPage.signIn("test@yahoo.commm", "test123");
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[text()='Incorrect username/password']")).isDisplayed());
    }
}
