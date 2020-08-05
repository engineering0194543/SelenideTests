package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private By nameLoc = By.id("login-form-username");
    private By passwordLoc = By.id("login-form-password");
    private By btnLoginLoc = By.id("login");
    private By loginFlagLoc = By.id("header-details-user-fullname");
    private By errorLogin = By.xpath("//*[contains(text(), 'Sorry, your username and password are incorrect - please try again.')]");
    private By errorMessageLoc = By.id("usernameerror");


    public void enterName(String name) {
        $(nameLoc).clear();
        $(nameLoc).sendKeys(name);
    }

    public void enterPassword(String password) {
        $(passwordLoc).clear();
        $(passwordLoc).sendKeys(password);
    }

    public void clickBtnLogin() {
        $(btnLoginLoc).click();
    }

    public boolean isFlagLogin(){
        $(loginFlagLoc).shouldBe(Condition.visible);
        return $(loginFlagLoc).isDisplayed();
    }

    public boolean errorMessageIsPresent(String message){
        $(errorLogin).shouldBe(Condition.visible);
        return $(errorLogin).getText().contains(message);
    }
}






