CREATE TABLE AllAnimals AS
SELECT 'Pets' AS SourceTable, ID, Name, Type, BirthDate, Commands, NULL AS AgeInMonths FROM Pets
UNION ALL
SELECT 'PackAnimals' AS SourceTable, ID, Name, Type, BirthDate, Commands, NULL AS AgeInMonths FROM PackAnimals
UNION ALL
SELECT 'HorsesAndDonkeys' AS SourceTable, ID, Name, Type, BirthDate, Commands, NULL AS AgeInMonths FROM HorsesAndDonkeys
UNION ALL
SELECT 'YoungAnimals' AS SourceTable, ID, Name, Type, BirthDate, Commands, AgeInMonths FROM YoungAnimals;
