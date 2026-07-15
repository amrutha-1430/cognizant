package SingletonPatternExample;

/**
 * Test class to verify the Singleton pattern implementation.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Starting Singleton Test ===");

        // Retrieve the logger instance for the first time
        Logger logger1 = Logger.getInstance();
        logger1.log("User logged in successfully.");

        // Attempt to retrieve the logger instance a second time
        Logger logger2 = Logger.getInstance();
        logger2.log("Database transaction completed.");

        System.out.println("\n=== Verification ===");
        
        // Compare references to ensure both variables point to the same memory block
        if (logger1 == logger2) {
            System.out.println("Result: SUCCESS! Both logger variables point to the exact same instance.");
            System.out.println("Logger 1 Memory ID: " + logger1.hashCode());
            System.out.println("Logger 2 Memory ID: " + logger2.hashCode());
        } else {
            System.out.println("Result: FAILURE! Multiple instances found.");
        }
    }
}
