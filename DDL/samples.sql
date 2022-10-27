DELETE FROM Product WHERE true;

INSERT INTO Product(name, shortDescription, description, brand, imageUrl, price, stock)
VALUES ('ThinkPad X270', 'A laptop', 'bla....', 'ThinkPad', 'https://sample.org/sample.jpg', 400, 500),
       ('Il nome della Rosa', 'Un romanzo.', 'Il frate, l\'inquisitore....', 'Mondadori', 'https://fdsfds.dfds', 20, 100),
       ('Coca Cola', 'una bibita', 'Lo zucchero, il caffé', 'Coca Cola', '', 1.5, 1000),
       ('Bibbia', 'un libro', 'Il Cristo', 'Mondadori', '', 15, 300),
       ('Moretti 33cl', 'una lattina', 'Fermantato il grano et voilà', 'Moretti', '', 3, 1000);