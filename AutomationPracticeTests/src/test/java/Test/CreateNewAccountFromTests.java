package Test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.CreateAccountFormPage;
import pages.NavBarPage;
import pages.MyAccountPage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateNewAccountFromTests extends BaseTest
{
    NavBarPage navBarPage;

    public CreateNewAccountFromTests(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        navBarPage = new NavBarPage(driver);
    }

    @Test
    public void userShouldBeAbleToCreateNewAccountWhenFillInAllRequiredData() {

        //Arrange

        //Go to authorization page
        AuthorizationPage authorizationPage = navBarPage.signInButtonClick();
        //Create new account
        String emailInput = generateRandomEmailAddress();

        CreateAccountFormPage createAccountForm = authorizationPage.typeIntoEmailAddressForCreatingNewAccount(emailInput)
                        .clickCreateAccountButton();

        //Act

        //Complete the form
        MyAccountPage myAccountPage = createAccountForm.typeIntoFirstNameInput("Katarzyna")
                .typeIntoLastNameInput("Kluszczynska")
                .typeIntoPasswordInput("12345")
                .typeIntoAddressInput("Testowa, Test S. A.")
                .typeIntoCityInput("Krakow")
                .selectState("Alabama")
                .typeIntoPostCodeInput("00000")
                .selectCountry("United States")
                .typeIntoMobilePhoneInput("000-0000")
                .typeIntoAddressAliasInput("My personal address")
                .clickSubmitAccountButton();

        //Assert

        Assert.assertEquals(myAccountPage.getPageHeadingText(), "MY ACCOUNT",
                "My account ");
        Assert.assertTrue(navBarPage.headerUserInfoIsDisplayed());
        Assert.assertEquals(navBarPage.getHeaderUserInfoText(), "Katarzyna Kluszczynska");
    }

    private String generateRandomEmailAddress() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy_hh_mm_ss");
        String emailInput = "test" + formatter.format(new Date()) + "@test.com";
        return emailInput;
    }
}
