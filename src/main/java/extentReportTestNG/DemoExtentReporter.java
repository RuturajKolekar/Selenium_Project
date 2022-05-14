package extentReportTestNG;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoExtentReporter {
	@Test
	public void run() {
		ExtentReports extentreports=new ExtentReports();
		ExtentSparkReporter sparkreport=new ExtentSparkReporter("D:\\Java Programs\\EclipsPrograms\\Guru99Test"
				+ "\\ExtentReport\\report.html");
		extentreports.attachReporter(sparkreport);
		
		extentreports.flush();
		
	}

	
	
}
