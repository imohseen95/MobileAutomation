import base.MobileAPI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class AlertPage extends MobileAPI {

    IOSDriver<IOSElement> driver;

    public AlertPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /********************************* UI Elements ********************************/

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Create App Alert']")
    public MobileElement createAppAlertButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Create Notification Alert']")
    public MobileElement createNotificationAlertButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeAlert/descendant:: XCUIElementTypeStaticText)[1]")
    public MobileElement alertHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeAlert/descendant:: XCUIElementTypeStaticText)[2]")
    public MobileElement alertMessage;

    /****************************** Custom Functions ******************************/

    public void verifyCreateNotificationAlert() {

        createNotificationAlertButton.click();
        alertHeader.isDisplayed();
        alertMessage.isDisplayed();
        String actualHeader = alertHeader.getText();
        String expectedHeader = "“IntegrationApp” Would Like to Send You Notifications";
        assertEquals(actualHeader, expectedHeader);

        String actualMessage = alertMessage.getText();
        String expectedMessage = "Notifications may include alerts, sounds, and icon badges. These can be configured in Settings.";
        assertEquals(actualMessage, expectedMessage);
        driver.switchTo().alert().accept();
    }
}
