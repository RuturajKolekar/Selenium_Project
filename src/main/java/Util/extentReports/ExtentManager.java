package Util.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager extends ExtentTestManager {
	public static final ExtentReports extentReports = new ExtentReports();

    public  static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("D:\\Java Programs\\EclipsPrograms\\Guru99Test\\extent-report.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "DCTC");
        extentReports.setSystemInfo("Author", "Ruturaj Kolekar");
        return extentReports;
    }

}
