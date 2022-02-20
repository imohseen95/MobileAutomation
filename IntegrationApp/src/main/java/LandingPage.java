import base.MobileAPI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends MobileAPI {

    IOSDriver<IOSElement> driver;

    public LandingPage(IOSDriver<IOSElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /********************************* UI Elements ********************************/

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Alerts']")
    public MobileElement alertButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Attributes']")
    public MobileElement attributeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Scrolling']")
    public MobileElement scrollingButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Deadlock app']")
    public MobileElement deadLockAppButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Touch']")
    public MobileElement touchButton;

    /****************************** Custom Functions ******************************/

    public void verifyLandingPageUiElements(){
        alertButton.isDisplayed();
        attributeButton.isDisplayed();
        scrollingButton.isDisplayed();
        deadLockAppButton.isDisplayed();
        touchButton.isDisplayed();
    }

    public AlertPage clickOnAlertButton() {
        alertButton.isDisplayed();
        alertButton.click();
        return new AlertPage(driver);
    }

    public AttributesPage clickOnAttributeButton() {
        attributeButton.isDisplayed();
        attributeButton.click();
        return new AttributesPage(driver);
    }

    public ScrollingPage clickOnScrollingButton() {
        scrollingButton.isDisplayed();
        scrollingButton.click();
        return new ScrollingPage(driver);
    }
}
