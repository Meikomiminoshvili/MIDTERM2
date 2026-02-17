package FinalProject;

import Steps.OfferResultPageSteps;
import Steps.SwoopHomePageSteps;
import org.testng.annotations.Test;

public class filterTest extends BaseTest{
    SwoopHomePageSteps swoopHomePageSteps = new SwoopHomePageSteps();
    OfferResultPageSteps offerResultPageSteps = new OfferResultPageSteps();
    @Test
    public void filterTest() throws InterruptedException {
        swoopHomePageSteps.goToFoodCategory();
        swoopHomePageSteps.closePopupIfPresent();
        offerResultPageSteps.applyGuests25Filter();
        offerResultPageSteps.validateAllOffersContain25InDescriptionOnAllPages();

    }

}
