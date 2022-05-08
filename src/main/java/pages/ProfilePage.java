package pages;

import base.PageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfilePage extends PageBase {

    public ProfilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    private By profileBtn           = By.xpath("//android.widget.FrameLayout[@content-desc='Profile']");
    private By settingsBtn          = By.id("com.runtastic.android:id/menu_profile_tab_settings");
    private By logoutBtn            = By.xpath("hierarchy//android.widget.FrameLayout[11]");
    private By totalPointsTxt       = By.id("com.runtastic.android:id/totalPoints");
    private By currentLvlTxt        = By.id("com.runtastic.android:id/currentLevel");
    private By showMoreTab          = By.id("com.runtastic.android:id/cta");
    private By adiClubPassScreen    = By.id("com.runtastic.android:id/passViewTitle");
    private By adiClubPassNumber    = By.xpath("hierarchy//android.view.View[5]");
    private By gotItBtn             = By.id("com.runtastic.android:id/explanationCta");
    private By backBtn              = By.xpath("hierarchy//android.widget.Button[1]");
    private By secondBackBtn        = By.xpath("hierarchy//android.widget.ImageButton[@content-desc='Navigate up']");
    private By pointsInfoViewScreen = By.id("com.runtastic.android:id/pointsInfoViewTitle");
    private By howToEarnPointsHeader= By.xpath("hierarchy//android.widget.TextView");
    private By checkPointsHistoryScreen = By.xpath("hierarchy//android.widget.LinearLayout[@content-desc='HISTORY']");
    private By historyHeader        = By.id("com.runtastic.android:id/engagementDate");


    public By goToProfileScreen() {
        return click(profileBtn);
    }

    public String getTotalPointsText(){
        return getTextFromUI(totalPointsTxt);
    }

    public String getCurrentLevelText(){
        return getTextFromUI(currentLvlTxt);
    }

    public By goToShowMoreScreen() {
        return click(showMoreTab);
    }

    public By goToAdiClubPassScreen() {
        return click(adiClubPassScreen);
    }

    public By goToPointsInfoViewScreen() {
        return click(pointsInfoViewScreen);
    }

    public By clickGotItButton() {
        return click(gotItBtn);
    }

    public String getAdiClubPassNumberText(){
        return getTextFromUI(adiClubPassNumber);
    }

    public String getHowToEarnPointsHeaderText(){
        return getTextFromUI(howToEarnPointsHeader);
    }

    public String getHistoryText(){
        return getTextFromUI(historyHeader);
    }

    public void goToCheckPointsHistoryScreen() {
        click(checkPointsHistoryScreen);
    }

    public void navigateBackToProfileScreen() {
        driver.navigate().back();
        driver.navigate().back();
    }

    public void logOutFromApp() {
        click(profileBtn);
        click(settingsBtn);
        scrollDown();
        click(logoutBtn);
    }

    
}
