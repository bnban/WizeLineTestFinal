package TestCases;

import PageFactory.SignUp_Address;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import DataProvider.Email_InvalidFormat;

public class SignUp_Personal_Test extends TestBase{
    PageFactory.SignUp_Personal SignUpPersonal;
    SignUp_Address SignUpAddress;

    @Test
    public void SignUpPersonalSuccessfully() {
        SignUpPersonal = new PageFactory.SignUp_Personal(driver);

        //Input information
        SignUpPersonal.tellUsAboutYourSelf("Test",
                "Test",
                "test20201@gmail.com",
                "June",
                "10",
                "2000",
                "Arabic");

        //Verify Step 2 is displayed
        SignUpAddress = new SignUp_Address(driver);
        Assert.assertNotNull(SignUpAddress.getTextStep2());
        SignUpAddress.clickBack();
    }

    @Test(dataProvider = "InvalidEmailFormat", dataProviderClass = Email_InvalidFormat.class)
    public void VerifyEmailFormat(String strEmail) throws InterruptedException {
        SignUpPersonal = new PageFactory.SignUp_Personal(driver);

        //Verify invalid email error displayed
        SignUpPersonal.setEmail(strEmail);
        Thread.sleep(1000);
        Assert.assertTrue(SignUpPersonal.isEmailErrorExisted());

        //Reset value of email to correct one
        SignUpPersonal.setEmail("god@gmail.com");
        Thread.sleep(1000);
        Assert.assertFalse(SignUpPersonal.isEmailErrorExisted());
    }
}
