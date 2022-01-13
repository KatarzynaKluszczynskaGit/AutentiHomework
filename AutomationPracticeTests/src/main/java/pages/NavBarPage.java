package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavBarPage extends BasePage
{
    public NavBarPage(WebDriver driver){ super(driver); }

    By SignInButton = By.className("login");
    By HeaderUserInfo = By.className("header_user_info");

    public AuthorizationPage signInButtonClick()
    {
        driver.findElement(SignInButton).click();
        return new AuthorizationPage(driver);
    }

    public boolean headerUserInfoIsDisplayed()
    {
        try{
            return driver.findElement(HeaderUserInfo).isDisplayed();
        } catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public String getHeaderUserInfoText()
    {
        return driver.findElement(HeaderUserInfo).getText();
    }
}
