package utils;

import org.testng.ITestResult;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomReporter implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		try (FileWriter writer = new FileWriter(outputDirectory + "/custom-report.html")) {
			writer.write("<html><head><title>Test Report</title>");
			writer.write(
					"<style>table {border-collapse: collapse;} td, th {border: 1px solid #ddd; padding: 8px;}</style></head>");
			writer.write("<body><h1>Test Execution Report</h1><table>");
			writer.write("<tr><th>Test</th><th>Status</th><th>Time</th><th>Parameters</th><th>Exception</th></tr>");

			for (ISuite suite : suites) {
				suite.getResults().values().forEach(result -> {
					result.getTestContext().getFailedTests().getAllResults().forEach(testResult -> {
						writeTestResult(writer, testResult, "FAILED");
					});
					result.getTestContext().getPassedTests().getAllResults().forEach(testResult -> {
						writeTestResult(writer, testResult, "PASSED");
					});
				});
			}

			writer.write("</table></body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeTestResult(FileWriter writer, ITestResult result, String status) {
		try {
			writer.write("<tr>");
			writer.write("<td>" + result.getName() + "</td>");
			writer.write("<td>" + status + "</td>");
			writer.write("<td>" + (result.getEndMillis() - result.getStartMillis()) + "ms</td>");

			// Fixed parameter formatting
			String parameters = formatParameters(result.getParameters());
			writer.write("<td>" + parameters + "</td>");

			writer.write("<td>" + (result.getThrowable() != null ? result.getThrowable().getMessage() : "") + "</td>");
			writer.write("</tr>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// New helper method
	private String formatParameters(Object[] params) {
		if (params == null || params.length == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (Object param : params) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(param.toString());
		}
		return sb.toString();
	}
}