package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp_Address {
    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Step 2')]")
    WebElement lblStep2;

    @FindBy(xpath = "//span[contains(text(),'Back')]")
    WebElement btnBack;

    public SignUp_Address(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextStep2(){
        return lblStep2.getText();
    }

    public void clickBack(){
        btnBack.click();
    }
}
