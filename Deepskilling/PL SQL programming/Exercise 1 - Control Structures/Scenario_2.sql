-- Scenario 2: Promote customers to VIP status (IsVIP to TRUE) if balance is over $10,000.
-- Note: Run ALTER TABLE Customers ADD IsVIP VARCHAR2(10) DEFAULT 'FALSE'; if the column does not exist.

BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance, Name
        FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.Name || ' (ID: ' || rec.CustomerID || ') promoted to VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
