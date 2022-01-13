package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage extends BasePage
{
    public AuthorizationPage(WebDriver driver)
    {
        super(driver);
    }

    By EmailCreateInput = By.id("email_create");
    By SubmitCreateButton = By.id("SubmitCreate");

    public AuthorizationPage typeIntoEmailAddressForCreatingNewAccount(String email)
    {
        driver.findElement(EmailCreateInput).sendKeys(email);
        return this;
    }

    public CreateAccountFormPage clickCreateAccountButton()
    {
        driver.findElement(SubmitCreateButton).click();
        return new CreateAccountFormPage(driver);
    }

}
