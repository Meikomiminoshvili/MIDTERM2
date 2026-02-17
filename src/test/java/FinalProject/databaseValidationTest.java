package FinalProject;

import Data.Offers;
import SQL.OfferRepository;
import Steps.OfferResultPageSteps;
import Steps.SwoopHomePageSteps;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class databaseValidationTest extends BaseTest {
    SwoopHomePageSteps swoopHomePageSteps = new SwoopHomePageSteps();
    OfferResultPageSteps offerResultPageSteps = new OfferResultPageSteps();

    @Test(priority = 1)
    public void validateRandomOffer() {
        Offers offerFromDb = OfferRepository.getRandomOffer();
        Assert.assertNotNull(offerFromDb, "Offer from DB should not be null");
        swoopHomePageSteps.searchOffer(offerFromDb.getName());
        offerResultPageSteps.validateOfferTitle(offerFromDb.getName());
        offerResultPageSteps.validateOfferPrice(offerFromDb.getPrice());
        offerResultPageSteps.validateOfferDiscount(offerFromDb.getDiscount());

    }

}








