package loggingexercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message: system status normal.");
        logger.info("Info message: application is processing request.");
        logger.warn("Warning message: disk space is low.");
        logger.error("Error message: database connection failed.");
    }
}
