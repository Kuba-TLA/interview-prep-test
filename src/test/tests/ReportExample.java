package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ReportExample extends BaseTest {
    @Test
    public void test01(){
        ExtentReports extentReports = new ExtentReports();

        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("TLA");
        spark.config().setReportName("Interview Prep Test");

        extentReports.attachReporter(spark);

        ExtentTest extentTest = extentReports.createTest("Home Page Test title");

        extentTest.assignAuthor("Kuba");
        extentTest.assignDevice("Mac OS");


        extentTest.pass("This test passed");
        extentTest.fail("This test failed");
        extentTest.skip("Test skipped");
        extentTest.warning("Warning result");

        extentTest.pass(MarkupHelper.createLabel("This test passed", ExtentColor.GREEN));
        extentTest.fail(MarkupHelper.createLabel("This test passed", ExtentColor.RED));

        String[] list = {"white", "black", "orange"};
        extentTest.info(MarkupHelper.createUnorderedList(list));

        String[][] table = {
                {"Tesla S Model", "$75000"},
                {"BMW 7 Series", "$70000"},
                {"Ford Explorer", "$55000"}
        };

        extentTest.info(MarkupHelper.createTable(table));

        extentReports.flush();
    }


}
