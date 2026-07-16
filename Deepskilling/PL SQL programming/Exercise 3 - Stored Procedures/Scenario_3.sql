-- Scenario 3: Transfer a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    -- Check source account balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_source_account;
    
    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    -- Perform Transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_account;
    
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_dest_account;
    
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_source_account || ' to Account ' || p_dest_account);
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Source or Destination Account does not exist.');
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in source account. Current balance is $' || v_balance);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
