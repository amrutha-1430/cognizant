package loggingexercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int id = 12345;
        logger.info("User {} with ID {} logged in successfully.", user, id);
    }
}
