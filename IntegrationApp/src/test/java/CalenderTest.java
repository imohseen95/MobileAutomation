import base.MobileAPI;
import org.testng.annotations.Test;

public class CalenderTest extends MobileAPI {

    LandingPage landingPage;
    AttributesPage attributesPage;

    @Test()
    public void verify_selecting_futureDate_from_datePicker() throws InterruptedException {

        landingPage = new LandingPage(driver);
        attributesPage = landingPage.clickOnAttributeButton();
        attributesPage.clickOnDatePicker();
        attributesPage.selectFutureDate();
        driver.closeApp();
    }

    @Test()
    public void verify_selecting_date_from_calender() throws InterruptedException {

        driver.launchApp();
        landingPage = new LandingPage(driver);
        attributesPage = landingPage.clickOnAttributeButton();
        attributesPage.clickOnDatePicker();
        attributesPage.selectDateFromCurrentMonth("10");
    }
}
