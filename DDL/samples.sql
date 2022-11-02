DELETE FROM Product WHERE true;

-- Insert birre
INSERT INTO Product(class, name, shortDescription, description, brand, imageUrl, price, stock, ingredients, alcoholPercentage, liquidVolumeInML)
VALUES ('Beer', 'Moretti 33cl', 'una lattina', 'Fermantato il grano et voilà', 'Moretti', '', 3, 1000, '???', 0.10, 330),
       ('Beer', 'Moretti 66cl', 'una lattina', 'Fermantato il grano et voilà', 'Moretti', '', 3, 1000, '???', 0.10, 660);

-- Insert libbris
INSERT INTO Product(class, name, shortDescription, description, brand, imageUrl, price, stock, summary, language, numberPages)
VALUES        ('Book', 'Il nome della Rosa', 'Un romanzo.', 'Il frate, l\'inquisitore....', 'Mondadori', 'https://fdsfds.dfds', 20, 100, 'blah blah blah', 'Italian', 500),
              ('Book', 'The bible', 'Sacre scritture', 'Bibbia CEI', 'Mondadori', '', 12, 500, 'Old and new testament', 'English', 1000);

-- Insert montiors
INSERT INTO Product(class, name, shortDescription, description, brand, imageUrl, price, stock, screenSizeInches, displayResolutionX, displayResolutionY, specialFeatures, refreshRateHz)
VALUES ('Monitor', 'LG24XXDSFDSFIOEWURJOIDFJ', 'A good monitor at the office or at home', 'This beauty can fit so many burnt pixel in it!', 'LG', '', 250,200, 24, 1920, 1080, 'Freesync\nfakeHDR\nfakeAudio', 75);
