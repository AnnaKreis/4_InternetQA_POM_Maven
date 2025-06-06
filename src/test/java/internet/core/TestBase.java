package internet.core;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] p) {
        logger.info("Start test" + method.getName() + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED: " + result.getMethod().getMethodName() + "Screenshot path: " + app.takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("===============================================================");
    }


}
