package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_AddNewUser {

    SHAFT.GUI.WebDriver driver;
    //Construactor
    public P04_AddNewUser(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }


    //Locators
    By userRoleDropDown =  By.xpath("//label[contains(.,'User Role')]/../following-sibling::div");
    By selectUserRole = By.xpath("//div[@class=\"oxd-select-option\"][contains(.,'Admin')]");
    By empolyeeNameInput =By.xpath("(//label[contains(.,'Employee Name')]//following::input)[1]");
    By getEmpolyeeNameInputEle= By.xpath("//span[@class=\"oxd-userdropdown-tab\"]//p");
    By selectEmpolyee = By.xpath("(//div[@role=\"option\"])[1]");
    By statusDropDown = By.xpath("//label[contains(.,'Status')]/../following-sibling::div");
    By selectStatus = By.xpath("//div[@class=\"oxd-select-option\"][contains(.,'Enabled')]");
    By userNameInput =By.xpath("(//label[contains(.,'Username')]//following::input)[1]");
    By passwordInut =By.xpath("(//label[contains(.,'Password')]//following::input)[1]");
    By confirmPasswordInput =By.xpath("(//label[contains(.,'Confirm Password')]//following::input)[1]");
    By saveBtn =By.xpath("//button[@type=\"submit\"]");




    //Methods{
    public P03_AdminPage fillForm(String newUserName , String NewPassword) throws InterruptedException {
        driver.element().click(userRoleDropDown).
                and().click(selectUserRole).
                and().type(empolyeeNameInput,getEmpolyeeName());
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until( d ->driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmpolyee));
        Thread.sleep(4000);
        driver.element().click(selectEmpolyee).and().click(statusDropDown).click(selectStatus).
                and().type(userNameInput,newUserName).
                and().type(passwordInut,NewPassword).
                and().type(confirmPasswordInput,NewPassword).
                and().click(saveBtn);
        //Thread.sleep(3000);
        return new P03_AdminPage(driver);
       // driver.browser().capturePageSnapshot();
    }

    public String getEmpolyeeName (){
       return driver.element().getText(getEmpolyeeNameInputEle);
    }

    }





