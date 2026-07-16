-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ', your Loan (ID: ' || rec.LoanID || ') is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || '. Please ensure payment is made.');
    END LOOP;
END;
/
