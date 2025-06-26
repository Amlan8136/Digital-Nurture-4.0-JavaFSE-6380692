BEGIN
  EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP VARCHAR2(5))';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE = -01430 THEN
      NULL; -- column already exists
    ELSE
      RAISE;
    END IF;
END;
/

BEGIN
  FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = rec.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

SELECT CustomerID, Name, Balance, IsVIP FROM Customers;
