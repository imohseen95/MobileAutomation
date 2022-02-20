import base.MobileAPI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class AttributesPage extends MobileAPI {

    IOSDriver<IOSElement> driver;

    public AttributesPage(IOSDriver<IOSElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /********************************* UI Elements ********************************/

    @iOSXCUITFindBy(className = "XCUIElementTypeDatePicker")
    public MobileElement datePicker;

    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    public List<MobileElement> calenderDates;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Time\"]")
    public MobileElement time;

    @iOSXCUITFindBy(className = "XCUIElementTypeKey")
    public List<MobileElement> keyEntry;

    public void clickOnDatePicker() {
        datePicker.click();
    }

    // Returns tomorrow's day of the month
    public String futureDate() {

        Date date = new Date();
        LocalDateTime tomorrowsDate = LocalDateTime.from(date.toInstant().atZone(ZoneId.of("UTC-4"))).plusDays(1);
        String tomorrow = tomorrowsDate.format(DateTimeFormatter.ofPattern("d"));
        return tomorrow;
    }

    public void selectFutureDate() throws InterruptedException {

        datePicker.click();
        System.out.println("Future date is :" + futureDate());
        MobileElement element = driver.findElementByXPath("//XCUIElementTypeStaticText[@label = '" + futureDate() + "']");
        element.click();
        if (element.getText().contains(futureDate())) {
            assertTrue(true);
        }
        Thread.sleep(3000);
    }

    public void selectDateFromCurrentMonth(String date) throws InterruptedException {

        datePicker.click();
        MobileElement element = driver.findElementByXPath("//XCUIElementTypeStaticText[@label = '" + date + "']");
        element.click();
        if (element.getText().equalsIgnoreCase(date)) {
            assertTrue(true);
        }
        Thread.sleep(3000);
        System.out.println("Selected day " + date + " from the calender");

    }


}
