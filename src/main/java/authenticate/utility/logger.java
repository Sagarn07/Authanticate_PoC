package authenticate.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logger {

    // Initialize Log4j2 logs
    private static final Logger logger = LogManager.getLogger(logger.class);

    // Start test case logging
    public static void startTestCase(String sTestCaseName) {
        logger.info("====================================={} TEST START=========================================", sTestCaseName);
    }

    // End test case logging
    public static void endTestCase(String sTestCaseName) {
        logger.info("====================================={} TEST END=========================================", sTestCaseName);
    }

    // Info level logging
    public static void info(String message) {
        logger.info(message);
    }

    // Warn level logging
    public static void warn(String message) {
        logger.warn(message);
    }

    // Error level logging
    public static void error(String message) {
        logger.error(message);
    }

    // Fatal level logging
    public static void fatal(String message) {
        logger.fatal(message);
    }

    // Debug level logging
    public static void debug(String message) {
        logger.debug(message);
    }
}