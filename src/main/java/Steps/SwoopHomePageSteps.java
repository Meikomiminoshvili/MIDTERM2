package Steps;

import Pages.SwoopHomePage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static Data.Constants.BASE_URL;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class SwoopHomePageSteps {
    SwoopHomePage swoopHomePage = new SwoopHomePage();

    @Step
    public void openSwoopPage() {
        open(BASE_URL);
    }

    @Step
    public void searchOffer(String text) {
        swoopHomePage.searchInput.setValue(text).pressEnter();

    }

    @Step
    public void goToFoodCategory() {
        swoopHomePage.categoryFood.shouldBe(visible).click();
    }

    @Step
    public  void closePopupIfPresent() throws InterruptedException {
        for (int i = 0; i < 25; i++) {

            if (swoopHomePage.popupCloseButton.exists()&&swoopHomePage.popupCloseButton.isDisplayed()) {
                swoopHomePage.popupCloseButton.click();
                break;
            }

            sleep(200);
        }
    }
}




