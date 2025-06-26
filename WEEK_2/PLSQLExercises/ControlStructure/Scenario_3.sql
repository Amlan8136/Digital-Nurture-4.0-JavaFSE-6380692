BEGIN
  FOR rec IN (
    SELECT C.Name, L.EndDate
    FROM Customers C
    JOIN Loans L ON C.CustomerID = L.CustomerID
    WHERE L.EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan for ' || rec.Name || ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
  END LOOP;
END;
/