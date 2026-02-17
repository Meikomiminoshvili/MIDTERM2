package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SwoopHomePage {
  public SelenideElement searchInput = $("[name='search']");
  public SelenideElement categoryFood = $("a[href='/category/15/kveba/']");
  public SelenideElement popupCloseButton = $("button[aria-label='Close']");
  public SelenideElement categorySport = $("a[href*='sporti']");





}
