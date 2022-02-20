import base.MobileAPI;
import org.testng.annotations.Test;

public class AlertTest extends MobileAPI {

    LandingPage landingPage;
    AlertPage alertScreen;
    ScrollViewPage scrollViewPage;
    ScrollingPage scrollingPage;

    @Test()
    public void verify_landingPage_UI_elements(){

        landingPage = new LandingPage(driver);
        landingPage.verifyLandingPageUiElements();
    }
    @Test()
    public void verify_integration_app_push_notification_alert(){

        landingPage = new LandingPage(driver);
        alertScreen = landingPage.clickOnAlertButton();
        alertScreen.verifyCreateNotificationAlert();
    }

    @Test()
    public void verify_scroll_until_fifty(){

        landingPage = new LandingPage(driver);
        scrollingPage = landingPage.clickOnScrollingButton();
        scrollViewPage = scrollingPage.clickOnScrollViewButton();
        scrollViewPage.scrollUntilFiftyAndVerify("50");
    }
}
