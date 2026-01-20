package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/target/extent-report.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("DPEducation Automation");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        return extent;
    }
}
