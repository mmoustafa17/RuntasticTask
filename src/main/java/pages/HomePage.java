package pages;

import base.PageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends PageBase {

    public HomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    private By submitBtn        = By.id("com.runtastic.android:id/startJourneyLoginButton");
    private By emailBtn         = By.id("com.runtastic.android:id/rt_login_button");
    private By emailTxt         = By.id("com.runtastic.android:id/textinput_placeholder");
    private By passwordTxt      = By.id("com.runtastic.android:id/password");
    private By loginBtn         = By.id("com.runtastic.android:id/loginButton");
    private By continueBtn      = By.id("com.runtastic.android:id/contentButton");
    private By gpsSwitch        = By.id("com.runtastic.android:id/locationSwitch");
    private By allowBtn         = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By readyToGoBtn     = By.id("com.runtastic.android:id/doneButton");
    private By startJourneyBtn  = By.id("com.runtastic.android:id/startJourneyButton");
    private By signUpBtn        = By.id("com.runtastic.android:id/mail_sign_up_button");
    private By titleToolbar     = By.id("com.runtastic.android:id/titleToolbar");



    public void goToRegisterNewUserScreen() {
        click(startJourneyBtn);
        click(signUpBtn);
    }

    public void loginToApp(String userName, String password) {
        click(submitBtn);
        click(emailBtn);
        moveToElementAndType(emailTxt, userName);
        type(passwordTxt, password);
        click(loginBtn);
    }

    public void setPermissions(){
        click(continueBtn);
        click(gpsSwitch);
        click(allowBtn);
        click(continueBtn);
        click(continueBtn);
        click(readyToGoBtn);
    }

    public String getTitleToolbarText(){
        return getTextFromUI(titleToolbar);
    }

}
