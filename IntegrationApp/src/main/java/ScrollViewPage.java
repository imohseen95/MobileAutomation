import base.MobileAPI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ScrollViewPage extends MobileAPI {

    IOSDriver<IOSElement> driver;

    public ScrollViewPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /********************************* UI Elements ********************************/

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Create App Alert']")
    public MobileElement createAppAlertButton;

    @SuppressWarnings("rawtypes")
    public void scrollToElementByText(String text) {

        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);

        while (!driver.findElementByIosNsPredicate("label == '" + text + "'").isDisplayed()) {
            new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
                    .release().perform();
        }
    }

    public void scrollUntilFiftyAndVerify(String number){
        scrollToElementByText(number);
        MobileElement element = driver.findElementByXPath("//XCUIElementTypeScrollView/child::XCUIElementTypeStaticText[@label = '" + number + "']");
        String actual = element.getText();
        String expected = number;
        assertEquals(actual, expected);

    }

}
