package FinalProject;

import Data.Constants;
import Steps.SwoopHomePageSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    SwoopHomePageSteps swoopHomePageSteps = new SwoopHomePageSteps();

    @BeforeMethod
    public void setup() {
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(Constants.BASE_URL);

    }


        @AfterMethod
        public void tearDown() {
            closeWebDriver();

        }

    }

