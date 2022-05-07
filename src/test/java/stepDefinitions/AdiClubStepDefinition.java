package stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.ProfilePage;
import pages.RegistrationPage;
import utilities.Helper;
import utilities.JsonDataReader;

import java.io.IOException;

public class AdiClubStepDefinition extends TestBase {

    JsonDataReader      jsonReader;
    HomePage            homePageObject;
    ProfilePage         ProfilePageObject;
    RegistrationPage    RegistrationPageObject;

    public AdiClubStepDefinition(){
        homePageObject              = new HomePage(driver);
        ProfilePageObject           = new ProfilePage(driver);
        RegistrationPageObject      = new RegistrationPage(driver);
        jsonReader                  = new JsonDataReader();
    }

    @Given("I have existing UserName and password")
    public void iHaveExistingUserNameAndPassword() throws IOException, ParseException {
        jsonReader.JsonReader();
        homePageObject.loginToApp(jsonReader.userName,jsonReader.password);
    }

    @When("^User set the permissions")
    public void userSetThePermissions(){
        homePageObject.setPermissions();
    }

    @And("^User go to profile tab")
    public void userGoToRepoScreen(){
        ProfilePageObject.goToProfileScreen();
    }

    @And("^User go to show more screen")
    public void userGoToShowMoreScreen(){
        ProfilePageObject.goToShowMoreScreen();
    }

    @And("^User go to adiClub pass screen")
    public void userGoToAdiClubPassScreen(){
        ProfilePageObject.goToAdiClubPassScreen();
        ProfilePageObject.clickGotItButton();
    }

    @And("^User go to how to earn points screen")
    public void userGoToHowToEarnPointsScreen(){
        ProfilePageObject.goToPointsInfoViewScreen();
    }

    @Then("^User make sure he has (.*) point and on (.*)$")
    public void userMakeSureHeHasPointsAndOnLevel(String expectedPoints,String currentLevel){
        Helper.assertEquals(expectedPoints,ProfilePageObject.getTotalPointsText(),1,true);
        Helper.assertEquals(currentLevel,ProfilePageObject.getCurrentLevelText(),1,true);
    }

    @Given("User navigate to registration screen")
    public void userNavigateToRegistrationScreen()  {
        homePageObject.goToRegisterNewUserScreen();
    }

    @When("^User fill mandatory fields for new registration with (.*) (.*) (.*) (.*) and (.*)$")
    public void userSetTheMandatoryFields(String fName,String lName,String genderType,String usedEmail,String passwd)  {
        RegistrationPageObject.registerNewUser(fName,lName,genderType,usedEmail,passwd);
    }

    @And("^User fill required additional steps")
    public void userFillRequiredAdditionalSteps(){
        RegistrationPageObject.fillRequiredAdditionalSteps();
    }

    @Then("^User validate that he registered successfully (.*)$")
    public void userMakeSureHeRegisteredSuccessfully(String fName){
        String expectedResult = "WELCOME "+fName.toUpperCase();
        Helper.assertEquals(expectedResult,homePageObject.getTitleToolbarText(),1,true);
    }

    @Then("^User validate that his adiClub pass displayed (.*)$")
    public void userMakeSureHisAdiClubPassDisplayed(String adiClubPass){
        Helper.assertEquals(adiClubPass,ProfilePageObject.getAdiClubPassNumberText(),1,true);
        ProfilePageObject.navigateBackToProfileScreen();
    }

    @Then("^User validate the is in how to earn points screen (.*)$")
    public void userMakeSureHisOnHowToEarnPointsScreen(String expectedResult){
        Helper.assertEquals(expectedResult,ProfilePageObject.getHowToEarnPointsHeaderText(),1,true);
        ProfilePageObject.navigateBackToProfileScreen();
    }
}
