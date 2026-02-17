package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class OfferDetailPage {
    public SelenideElement offerDescription =
            $("[data-testid='offer-description']");

    private static final Pattern RANGE =
            Pattern.compile("(\\d+)\\s*-\\s*(\\d+)");

    private static final Pattern SINGLE =
            Pattern.compile("(\\d+)\\s*სტუმ");

    public int[] getGuestRange() {

        String text = offerDescription.getText();
        Matcher rangeMatcher = RANGE.matcher(text);
        if (rangeMatcher.find()) {
            int min = Integer.parseInt(rangeMatcher.group(1));
            int max = Integer.parseInt(rangeMatcher.group(2));
            return new int[]{min, max};
        }

        Matcher singleMatcher = SINGLE.matcher(text);
        if (singleMatcher.find()) {
            int number = Integer.parseInt(singleMatcher.group(1));
            return new int[]{number, number};
        }

        throw new AssertionError("სტუმრების რაოდენობა ვერ ვიპოვე აღწერაში!");
    }
}

