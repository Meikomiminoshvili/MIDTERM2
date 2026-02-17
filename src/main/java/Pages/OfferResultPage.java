package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class OfferResultPage {

    public SelenideElement firstOfferCard = $("a[href^='/offers/']");

    public SelenideElement offerTitle =
            $x("(//a[starts-with(@href,'/offers/')])[1]//h3");


    public SelenideElement offerPrice =
            $x("(//a[starts-with(@href,'/offers/')])[1]//p[contains(.,'₾') " +
                    "and contains(@class,'font-tbcx-bold')]");

    public SelenideElement offerDiscount =
            $x("(//a[starts-with(@href,'/offers/')])[1]//div[contains(@class,'bg-danger')]//p[contains(.,'%')]");

    public SelenideElement filterGuestQuantity =  $$("[data-testid='filter-button']").findBy(visible);
    public SelenideElement guestsDropdownOpen = $("div[data-headlessui-state='open']");
    public SelenideElement guestOption = guestsDropdownOpen.$$("p").findBy(text("2-5 სტუმარი"));
    public ElementsCollection allOffers =
            $$("a[href*='/offers/']");
    public SelenideElement nextPage =
            $("img[alt='right arrow']");
    public SelenideElement priceRange100_200 =
            $$("div[role='radio']")
                    .findBy(Condition.text("100 ₾ - 200 ₾"));
    public SelenideElement applyPriceFilter =
            $("[data-testid='tertiary-button']");
    public ElementsCollection offerPrices =
            $$x("//a[starts-with(@href,'/offers/')]//p[contains(.,'₾') and contains(@class,'font-tbcx-bold')]");
}










