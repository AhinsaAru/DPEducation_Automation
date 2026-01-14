package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String screenshotPath =
                    "screenshots/" + testName + "_" + timestamp + ".png";

            File src =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File(screenshotPath);
            FileUtils.copyFile(src, dest);

            return screenshotPath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
