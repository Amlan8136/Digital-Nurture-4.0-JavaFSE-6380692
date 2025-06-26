CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept IN VARCHAR2,
  bonus_pct IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonus_pct / 100)
  WHERE Department = dept;
  COMMIT;
END;
/


SELECT EmployeeID, Name, Department, Salary FROM Employees WHERE Department = 'IT';
