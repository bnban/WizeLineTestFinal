package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_Personal {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id ="firstName")
    WebElement txtFirstName;

    @FindBy(id ="lastName")
    WebElement txtLastName;

    @FindBy(id ="email")
    WebElement txtEmail;

    @FindBy(id ="emailError")
    WebElement lblEmailError;

    @FindBy(css ="#birthMonth")
    WebElement lstBirthMonth;

    @FindBy(css ="#birthDay")
    WebElement lstBirthDay;

    @FindBy(css ="#birthYear")
    WebElement lstBirthYear;

    @FindBy(css =".input-xs")
    WebElement lstLanguages;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement btnNext;

    @FindBy(xpath = "//input[@type='search']")
    WebElement txtInputMonth;

    @FindBy(xpath = "(//input[@type='search'])[2]")
    WebElement txtInputDay;

    @FindBy(xpath = "(//input[@type='search'])[3]")
    WebElement txtInputYear;

    public SignUp_Personal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String strFirstName){
        txtFirstName.sendKeys(strFirstName);
    }

    public void setLastName(String strLastName){
        txtLastName.sendKeys(strLastName);
    }

    public void setEmail(String strEmail){
        txtEmail.clear();
        txtEmail.sendKeys(strEmail);
    }

    public void setMonth(String strMonth){
        lstBirthMonth.click();
        txtInputMonth.sendKeys(strMonth);
        txtInputMonth.sendKeys(Keys.ENTER);
    }

    public void setDay(String strDay){
        lstBirthDay.click();
        txtInputDay.sendKeys(strDay);
        txtInputDay.sendKeys(Keys.ENTER);
    }

    public void setYear(String strYear){
        lstBirthYear.click();
        txtInputYear.sendKeys(strYear);
        txtInputYear.sendKeys(Keys.ENTER);
    }

    public void setLanguage(String strLanguage){
        lstLanguages.click();
        lstLanguages.sendKeys(strLanguage);
    }

    public void clickNext(){
        btnNext.click();
    }

    public void tellUsAboutYourSelf(String strFirstName, String strLastName, String strEmail, String strMonth, String strDay, String strYear, String strLanguage){
        setFirstName(strFirstName);
        setLastName(strLastName);
        setEmail(strEmail);
        setMonth(strMonth);
        setDay(strDay);
        setYear(strYear);
        setLanguage(strLanguage);
        clickNext();
    }

    public boolean isEmailErrorExisted(){
        /*try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(lblEmailError));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }*/
        return lblEmailError.isDisplayed();
    }
}
