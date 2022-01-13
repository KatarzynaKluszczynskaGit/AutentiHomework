package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountFormPage extends BasePage
{
    public CreateAccountFormPage(WebDriver driver)
    {
        super(driver);
    }

    By FirstNameInput = By.id("customer_firstname");
    By LastNameInput = By.id("customer_lastname");
    By PasswordInput = By.id("passwd");
    By AddressInput = By.id("address1");
    By CityInput = By.id("city");
    By StateSelect = By.id("id_state");
    By CountrySelect = By.id("id_country");
    By PostCodeInput= By.id("postcode");
    By MobilePhoneInput= By.id("phone_mobile");
    By AddressAliasInput= By.id("alias");
    By SubmitAccountButton= By.id("submitAccount");

    public CreateAccountFormPage typeIntoFirstNameInput(String firstName)
    {
        driver.findElement(FirstNameInput).sendKeys(firstName);
        return this;
    }

    public CreateAccountFormPage typeIntoLastNameInput(String lastName)
    {
        driver.findElement(LastNameInput).sendKeys(lastName);
        return this;
    }

    public CreateAccountFormPage typeIntoPasswordInput(String password)
    {
        driver.findElement(PasswordInput).sendKeys(password);
        return this;
    }

    public CreateAccountFormPage typeIntoAddressInput(String address)
    {
        driver.findElement(AddressInput).sendKeys(address);
        return this;
    }

    public CreateAccountFormPage typeIntoCityInput(String city)
    {
        driver.findElement(CityInput).sendKeys(city);
        return this;
    }

    public CreateAccountFormPage selectState(String state)
    {
        Select drpState = new Select((driver.findElement(StateSelect)));
        drpState.selectByVisibleText(state);
        return this;
    }

    public CreateAccountFormPage typeIntoPostCodeInput(String postCode)
    {
        driver.findElement(PostCodeInput).sendKeys(postCode);
        return this;
    }

    public CreateAccountFormPage selectCountry(String country)
    {
        Select drpCountry = new Select((driver.findElement(CountrySelect)));
        drpCountry.selectByVisibleText(country);
        return this;
    }

    public CreateAccountFormPage typeIntoMobilePhoneInput(String phone)
    {
        driver.findElement(MobilePhoneInput).sendKeys(phone);
        return this;
    }

    public CreateAccountFormPage typeIntoAddressAliasInput(String address)
    {
        driver.findElement(AddressAliasInput).clear();
        driver.findElement(AddressAliasInput).sendKeys(address);
        return this;
    }

    public MyAccountPage clickSubmitAccountButton()
    {
        driver.findElement(SubmitAccountButton).click();
        return new MyAccountPage(driver);
    }

}
