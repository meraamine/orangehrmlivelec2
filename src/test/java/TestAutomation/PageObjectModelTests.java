package TestAutomation;

import Pages.P01_LoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PageObjectModelTests {

        SHAFT.GUI.WebDriver driver;
        SHAFT.TestData.JSON testData;

        //Test Methods
        @Test
        public void login() throws InterruptedException {
           new P01_LoginPage(driver).loginSteps(testData.getTestData("userName"),testData.getTestData("password"))
                   .clickOnAdminTab().getOrignalRecords()
                   .clickOnAddBtn()
                   .fillForm(testData.getTestData("newUserName"),testData.getTestData("NewPassword"))
                   .formSubmittedSuccessfully().
                   getOrignalRecords_AfterAddingNewUser().
                   numberOfRecrds_IncreasedBy1();
           Thread.sleep(3500);
        }


        //Before Method
        @BeforeClass
        public void setUp() throws InterruptedException {
            driver = new SHAFT.GUI.WebDriver();
            driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            testData= new SHAFT.TestData.JSON("orangeTestData.json");


        }

        //After Method
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }

