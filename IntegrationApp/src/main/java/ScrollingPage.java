import base.MobileAPI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollingPage extends MobileAPI {

    IOSDriver<IOSElement> driver;

    public ScrollingPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /********************************* UI Elements ********************************/

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TableView']")
    public MobileElement tableViewButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ScrollView']")
    public MobileElement scrollViewButton;

    public ScrollViewPage clickOnScrollViewButton() {
        scrollViewButton.isDisplayed();
        scrollViewButton.click();
        return new ScrollViewPage(driver);
    }
}
