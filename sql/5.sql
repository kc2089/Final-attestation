CREATE TABLE YoungAnimals AS
SELECT *, TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths
FROM Pets
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT *, TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths
FROM PackAnimals
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;
