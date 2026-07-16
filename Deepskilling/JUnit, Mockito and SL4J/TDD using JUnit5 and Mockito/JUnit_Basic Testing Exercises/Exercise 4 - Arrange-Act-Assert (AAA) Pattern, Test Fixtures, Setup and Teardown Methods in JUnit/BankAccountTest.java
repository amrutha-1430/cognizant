package junitexercise;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Simple class to be tested
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

// JUnit Test Class implementing AAA Pattern, Setup, and Teardown
public class BankAccountTest {

    private BankAccount account;

    // SETUP METHOD: Runs before every single @Test method
    @Before
    public void setUp() {
        // Arrange (Global setup for tests)
        account = new BankAccount(100.0);
        System.out.println("Setup: Test environment initialized with a $100 balance.");
    }

    // TEARDOWN METHOD: Runs after every single @Test method
    @After
    public void tearDown() {
        // Clean up resources
        account = null;
        System.out.println("Teardown: Test environment cleaned up.");
    }

    @Test
    public void testDeposit() {
        // 1. Arrange (Specific inputs for this execution)
        double depositAmount = 50.0;

        // 2. Act (Execute the behavior being tested)
        account.deposit(depositAmount);

        // 3. Assert (Verify the actual outcome matches the expected outcome)
        assertEquals(150.0, account.getBalance(), 0.001);
    }
}
