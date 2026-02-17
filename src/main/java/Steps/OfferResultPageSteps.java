package Steps;

import Pages.OfferDetailPage;
import Pages.OfferResultPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;
import static org.aspectj.bridge.Version.getText;
import static org.testng.Assert.assertEquals;

public class OfferResultPageSteps {
    OfferResultPage offerResultPage = new OfferResultPage();
    OfferDetailPage offerDetailPage = new OfferDetailPage();

    @Step
    public void validateOfferTitle(String expectedTitle) {
        offerResultPage.firstOfferCard.shouldBe(visible);
        offerResultPage.offerTitle.shouldBe(visible);
        String uiTitle = offerResultPage.offerTitle.getText().trim();

        assertEquals(uiTitle, expectedTitle,
                "Title mismatch!");
    }

    @Step
    public void validateOfferPrice(double expectedPrice) {

        offerResultPage.offerPrice.shouldBe(visible);

        String uiPriceText = offerResultPage.offerPrice.getText()
                .replace("₾", "")
                .trim();

        double uiPrice = Double.parseDouble(uiPriceText);

        assertEquals(uiPrice, expectedPrice,
                "Price mismatch!");

    }
    @Step
    public void validateOfferDiscount(int expectedDiscount) {
        offerResultPage.offerDiscount.shouldBe(visible);

        String uiDiscountText = offerResultPage.offerDiscount.getText()
                .replace("-", "")
                .replace("%", "")
                .trim();

        int uiDiscount = Integer.parseInt(uiDiscountText);

        assertEquals(uiDiscount, expectedDiscount,
                "Discount mismatch!");
    }
    @Step
    public void applyGuests25Filter() {
        offerResultPage.allOffers.first().shouldBe(Condition.visible);
        offerResultPage.filterGuestQuantity.shouldBe(Condition.visible).click();
        offerResultPage.guestsDropdownOpen.shouldBe(visible);
        offerResultPage.guestOption.shouldBe(Condition.visible).click();
        offerResultPage.allOffers.first().shouldBe(visible);

    }



    @Step
    public void validateAllOffersContain25InDescriptionOnAllPages(){

        while (true) {

       offerResultPage.allOffers.first()
                .shouldBe(Condition.visible);

        int offersCount = offerResultPage.allOffers.size();

        for (int i = 0; i < offersCount; i++) {

            offerResultPage.allOffers.get(i)
                    .scrollTo()
                    .click();

            offerDetailPage.offerDescription
                    .shouldBe(Condition.visible);

            int[] guests = offerDetailPage.getGuestRange();

            Assert.assertTrue(
                    guests[0] >= 2 && guests[1] <= 5,
                    "სტუმრების რაოდენობა არ ჯდება 2-5 ფილტრში"
            );

            back();

            offerResultPage.allOffers.first()
                    .shouldBe(Condition.visible);
        }

        if (!offerResultPage.nextPage.exists()
                || !offerResultPage.nextPage.isDisplayed()) {
            break;
        }

        offerResultPage.nextPage.scrollTo().click();
    }
    }

    }






