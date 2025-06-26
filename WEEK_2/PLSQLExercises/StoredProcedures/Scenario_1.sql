CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
    UPDATE Accounts
    SET Balance = rec.Balance + (rec.Balance * 0.01)
    WHERE AccountID = rec.AccountID;
  END LOOP;
  COMMIT;
END;
/

SELECT AccountID, CustomerID, AccountType, Balance FROM Accounts WHERE AccountType = 'Savings';
