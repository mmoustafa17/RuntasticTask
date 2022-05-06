package stepDefinitions;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks{

	@Before
	public void beforeScenario() throws MalformedURLException {
		TestBase.AndroidSetUp();
	}

	@After(value = "@LogOutFromApp")
	public void logOutFromApp() throws IOException {
		TestBase.logOutFromApp();
		TestBase.tearDown();
	}

	@After(value = "@SetPerAndLogOutFromApp")
	public void setPerAndLogOutFromApp() throws IOException {
		TestBase.setPerAndLogOutFromApp();
		TestBase.tearDown();
	}
}
