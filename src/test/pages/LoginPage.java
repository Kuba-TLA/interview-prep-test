package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage extends BasePage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//div[@class='container']/button")
    public WebElement loginBtn;

    public void signIn(){
        String filePath = "src/test/data/config/configuration.properties";
        LoginPage loginPage = new LoginPage(driver);
        //username.sendKeys("test@yahoo.com");
        loginPage.sendKeys(username, ConfigReader.readProperty(filePath, "username"));
        //password.sendKeys("test123");
        loginPage.sendKeys(password, ConfigReader.readProperty(filePath, "password"));
        loginPage.click(loginBtn);
    }

    public void signIn(String email, String passwordValue){
        LoginPage loginPage = new LoginPage(driver);
        //username.sendKeys("test@yahoo.com");
        loginPage.sendKeys(username, email);
        //password.sendKeys("test123");
        loginPage.sendKeys(password, passwordValue);
        loginPage.click(loginBtn);
    }

}
