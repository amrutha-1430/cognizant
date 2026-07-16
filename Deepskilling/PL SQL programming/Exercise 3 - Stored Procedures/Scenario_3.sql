CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN accounts.account_id%TYPE,
    p_to_account_id   IN accounts.account_id%TYPE,
    p_amount          IN NUMBER
) IS
    v_balance accounts.balance%TYPE;
BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_account_id;

    IF v_balance >= p_amount THEN
        UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
        UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;
        COMMIT;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Invalid account ID.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END TransferFunds;
/
