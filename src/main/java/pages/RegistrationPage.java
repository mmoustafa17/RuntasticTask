package pages;

import base.PageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Helper;

import java.util.List;

public class RegistrationPage extends PageBase {

    public RegistrationPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String date = "-" + Helper.getSystemDate("dd-MM-yyyy-ss");

    private By firstNameTxt                     = By.id("com.runtastic.android:id/firstName");
    private By lastNameTxt                      = By.id("com.runtastic.android:id/lastName");
    private By mailBtn                          = By.id("com.runtastic.android:id/maleChip");
    private By femaleBtn                        = By.id("com.runtastic.android:id/femaleChip");
    private By preferNotToSayBtn                = By.id("com.runtastic.android:id/preferNotToSayChip");
    private By emailTxt                         = By.id("com.runtastic.android:id/email");
    private By passwordTxt                      = By.id("com.runtastic.android:id/password");
    private By birthdatePicker                  = By.id("com.runtastic.android:id/birthdatePicker");
    private By yearDatePicker                   = By.xpath("//android.widget.NumberPicker[3]/android.widget.EditText");
    private By monthDatePicker                  = By.xpath("//android.widget.NumberPicker[1]/android.widget.EditText");
    private By dayDatePicker                    = By.xpath("//android.widget.NumberPicker[2]/android.widget.EditText");
    private By dateOkBtn                        = By.id("android:id/button1");
    private By joinBtn                          = By.id("com.runtastic.android:id/joinButton");
    private By dataTransferSelectionRadioBtn    = By.id("com.runtastic.android:id/dataTransferSelection");
    private By termsAndConditionsRadioBtn       = By.id("com.runtastic.android:id/tosSelection");
    private By privacyPolicySelectionRadioBtn   = By.id("com.runtastic.android:id/privacyPolicySelection");
    private By consentBtn                       = By.id("com.runtastic.android:id/consentButton");
    private By primaryBtn                       = By.id("com.runtastic.android:id/primaryButton");


    public String registerNewUser(String fName, String lName, String genderType, String usedEmail
            , String passwd,String month,String day,String year) {
        type(firstNameTxt, fName);
        type(lastNameTxt, lName);

        switch (genderType) {
            case "Male":
                click(mailBtn);
                break;
            case "Female":
                click(femaleBtn);
            case "PreferNotToSay":
                click(preferNotToSayBtn);
                break;
        }

        String registrationEmail = usedEmail + date + "@hotmail.com";
        type(emailTxt, registrationEmail);
        type(passwordTxt, passwd);
        click(birthdatePicker);

        click(monthDatePicker);
        type(monthDatePicker,month);

        click(dayDatePicker);
        type(dayDatePicker,day);

        click(yearDatePicker);
        type(yearDatePicker,year);

        click(dateOkBtn);
        click(joinBtn);
        return registrationEmail;
    }

    public void fillRequiredAdditionalSteps(){
        click(dataTransferSelectionRadioBtn);
        click(termsAndConditionsRadioBtn);
        click(privacyPolicySelectionRadioBtn);
        click(consentBtn);
        click(primaryBtn);
    }

}
