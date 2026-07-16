-- Scenario 1: Apply a discount to loan interest rates for customers above 60 years old.
BEGIN
    FOR rec IN (
        SELECT l.LoanID, l.InterestRate, c.DOB, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        -- Calculate age in years
        IF (MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || rec.LoanID || ' for Customer: ' || rec.Name);
        END IF;
    END LOOP;
    COMMIT;
END;
/
