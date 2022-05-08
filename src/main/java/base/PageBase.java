/**
 * Engineer Mohamed Moustafa 2022.
 * All Rights Reserved.
 * <p>
 * ver          Creator          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00     Mohamed Moustafa    08/02/2022  - Script created.
 */
package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    public AppiumDriver driver;


    public static final int WAIT = 10;
    public AndroidTouchAction actions;

    //Super constructor
    protected PageBase(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitForVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public boolean waitFor(ExpectedCondition<?> expectedCondition, Duration duration) {
        try {
            FluentWait<AppiumDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(duration)
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);
            fluentWait.until(expectedCondition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public By click(By element) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(element), Duration.ofSeconds(15));
        WebElement clickableElement = driver.findElement(element);
        System.out.println("Clicked successfully on [" + clickableElement.getText() + "]");
        clickableElement.click();
        return element;
    }

    public String type(By element, String inputText) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(element), Duration.ofSeconds(15));
        WebElement textElement = driver.findElement(element);
        textElement.clear();
        textElement.sendKeys(inputText);
        System.out.println("Typed successfully [" + inputText + "] in " + textElement.getText());
        return inputText;
    }

    public String getTextFromUI(By element) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(element), Duration.ofSeconds(15));
        WebElement textElement = driver.findElement(element);
        String text = textElement.getText();
        System.out.println("Text found on UI as [" + text + "] in ");
        return text;
    }

    public void moveToElementAndType(By element, String inputText) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(element), Duration.ofSeconds(15));
        WebElement textElement = driver.findElement(element);
        textElement.clear();
        Actions action = new Actions(driver);
        action.moveToElement(textElement)
                .sendKeys(inputText)
                .build()
                .perform();
        System.out.println("Typed successfully [" + inputText + "]");

    }

    public void moveToElementAndClick(By element) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(element), Duration.ofSeconds(15));
        WebElement textElement = driver.findElement(element);
        System.out.println("Clicked successfully [" + textElement + "]");
        Actions action = new Actions(driver);
        action.moveToElement(textElement)
                .click()
                .build()
                .perform();
    }

    public void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }


    //you can add below more methods for different types of inputs like checkboxes or dropdown lists and so on
}


