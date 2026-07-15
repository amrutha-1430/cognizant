package SingletonPatternExample;

/**
 * A Singleton Logger utility class.
 * Ensures only one instance exists to provide consistent logging.
 */
public class Logger {
    // 1. Private static variable to hold the single instance of the class
    private static Logger instance;

    // 2. Private constructor to prevent instantiation from other classes
    private Logger() {
        System.out.println("[SYSTEM]: Logger initialized for the first time.");
    }

    // 3. Public static method to provide global access to the instance
    public static Logger getInstance() {
        // Lazy initialization: create instance only when needed
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A utility method to simulate logging functionality
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
