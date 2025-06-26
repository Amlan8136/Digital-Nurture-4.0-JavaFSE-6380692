BEGIN
  FOR c IN (
    SELECT LoanID, DOB FROM Customers JOIN Loans USING (CustomerID)
  ) LOOP
    IF MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60 THEN
      UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = c.LoanID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

SELECT CustomerID, LoanAmount, InterestRate FROM Loans;

