package Steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.screenshot;

public class MyCustomListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        TakeScreenshot();
        takeScreenshotbyAnotation();
    }

    public void TakeScreenshot() {
        screenshot("სურათის სახელი");
        byte[] myScreenshot = screenshot(OutputType.BYTES);
        try {
            Allure.addAttachment("On Test Fail Picture",
                    "image/png", new ByteArrayInputStream(myScreenshot),
                    "png");


        } catch (Exception _) {
        }
    }
    @Attachment(value = "Alternative Screenshot", type = "image/png")
    public byte[] takeScreenshotbyAnotation(){
        return screenshot(OutputType.BYTES);
    }
}

