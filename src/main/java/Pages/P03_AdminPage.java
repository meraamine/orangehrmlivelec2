package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_AdminPage {

    SHAFT.GUI.WebDriver driver;
    static  int orignialNumberofRecrds , cnumberOfRecordsAfterAddingUser;

    //Construactor
    public P03_AdminPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }

    //Locators
    By numberOfRecordsEle = By.xpath("//span[@class=\"oxd-text oxd-text--span\"][contains(.,'Records')]");
    By addButton = By.xpath("//i[contains(@class,'oxd-button-icon')]//parent::button");
    By successMsg = By.xpath("//div[@class=\"oxd-toast-start\"]//p[contains(.,'Successfully Saved')]");


    //Method{
    public int getNumberOfRecords(){
        int numberOfRecords = Integer.parseInt(driver.element().getText(numberOfRecordsEle).replaceAll("[^0-9]",""));
        System.out.println( "  Number of Records Found : " + numberOfRecords);
        return   numberOfRecords;
    }


    public P03_AdminPage getOrignalRecords (){
        orignialNumberofRecrds =getNumberOfRecords();
        System.out.println("Original Number Of Records Found: " +orignialNumberofRecrds);
        return this;
    }

    public  P03_AdminPage getOrignalRecords_AfterAddingNewUser (){
        cnumberOfRecordsAfterAddingUser =getNumberOfRecords();
        System.out.println("Original Number Of Records Found: " + cnumberOfRecordsAfterAddingUser);
        return this;
    }

    public P04_AddNewUser clickOnAddBtn(){
        driver.element().click(addButton);
        return new P04_AddNewUser(driver);
    }

    public P03_AdminPage formSubmittedSuccessfully(){
        driver.element().assertThat(successMsg).exists().perform();
        return this;

    }
    public void   numberOfRecrds_IncreasedBy1(){
        SHAFT.Validations.verifyThat().object(cnumberOfRecordsAfterAddingUser)
                .isEqualTo(orignialNumberofRecrds+1).perform();
    }
}