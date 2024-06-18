DELETE FROM PackAnimals WHERE Type = 'Camel';

CREATE TABLE HorsesAndDonkeys AS
SELECT * FROM PackAnimals WHERE Type IN ('Horse', 'Donkey');

