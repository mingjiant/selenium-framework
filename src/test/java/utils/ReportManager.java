package utils;

import com.aventstack.extentreports.ExtentTest;

public class ReportManager {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void logInfo(String message) {
        if (getTest() != null) {
            getTest().info(message);
        } else {
            System.out.println("Report not initialized: " + message);
        }
    }

    public static void logPass(String message) {
        getTest().pass(message);
    }

    public static void logFail(String message) {
        getTest().fail(message);
    }

}