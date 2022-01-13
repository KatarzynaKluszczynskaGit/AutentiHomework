package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage
{
    public MyAccountPage(WebDriver driver){ super(driver); }

    By PageHeading = By.className("page-heading");

    public String getPageHeadingText()
    {
        return driver.findElement(PageHeading).getText();
    }
}
