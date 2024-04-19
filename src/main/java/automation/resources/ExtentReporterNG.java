package automation.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	
	public static ExtentReports getReportObject() {
		
		
		String reportPath = System.getProperty("user.dir")+"\\reports\\reportindex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Web automation report results");
		reporter.config().setDocumentTitle("Test Reports Results");
		
		
		
		ExtentReports reportExtent = new ExtentReports();
         reportExtent.attachReporter(reporter);
         reportExtent.setSystemInfo("QA", "Tester");
         return reportExtent;
		
		
	}

}
