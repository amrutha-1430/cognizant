-- Scenario 1: Calculate and update the balance of all savings accounts by applying an interest rate of 1% to the current balance.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% processed for all savings accounts.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END;
/
