package com.css.training.testng.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;




public class CustomReport implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		try {
			System.err.println("[CustomReport] file lication is "+outputDirectory);
			FileWriter file = new FileWriter(outputDirectory
					+ "/CustomReport.txt");

			StringWriter sw = new StringWriter();
			for (ISuite suite : suites) {
				String suiteName = suite.getName();
				Map<String, ISuiteResult> suiteResults = suite.getResults();
				for (ISuiteResult sr : suiteResults.values()) {
					ITestContext tc = sr.getTestContext();
					sw.append("[CustomReport] Passed tests for suite '"
							+ suiteName + "' is:"
							+ tc.getPassedTests().getAllResults().size());
					sw.append("[CustomReport] Failed tests for suite '"
							+ suiteName + "' is:"
							+ tc.getFailedTests().getAllResults().size());
					sw.append("[CustomReport] Skipped tests for suite '"
							+ suiteName + "' is:"
							+ tc.getSkippedTests().getAllResults().size());
				}
			}
			file.write(sw.toString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}