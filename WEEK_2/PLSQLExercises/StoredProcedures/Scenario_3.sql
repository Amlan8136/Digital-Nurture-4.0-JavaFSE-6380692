CREATE OR REPLACE PROCEDURE TransferFunds(
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amount IN NUMBER
) AS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance
  FROM Accounts
  WHERE AccountID = from_acc
  FOR UPDATE;

  IF from_balance >= amount THEN
    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_acc;
    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_acc;
    COMMIT;
  ELSE
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for transfer.');
  END IF;
END;
/

EXEC TransferFunds(1, 2, 100);

SELECT AccountID, CustomerID, Balance FROM Accounts WHERE AccountID IN (1, 2);

