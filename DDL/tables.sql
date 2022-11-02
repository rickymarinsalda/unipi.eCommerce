DROP DATABASE IF EXISTS eCommerce;
CREATE DATABASE eCommerce CHARACTER SET 'utf8mb4';

USE eCommerce;

-- tabelle

CREATE TABLE Company(
    name        VARCHAR(100) PRIMARY KEY,
    logoUrl     TINYTEXT NOT NULL,
    website     TINYTEXT NOT NULL

);

CREATE TABLE RegisteredUser(
    id             INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    firstName      VARCHAR(100) NOT NULL,
    lastName       VARCHAR(100) NOT NULL,
    username       VARCHAR(200) UNIQUE KEY NOT NULL,
    password       VARCHAR(255) NOT NULL,
    profilePicUrl  TINYTEXT NOT NULL,
    active         BOOLEAN DEFAULT TRUE NOT NULL,
    createdDate    TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updatedDate    TIMESTAMP NULL

);

CREATE TABLE Manager(
    id          INT UNSIGNED PRIMARY KEY,
    hiredDate   DATE NOT NULL,
    title       VARCHAR(200),
    nameCompany VARCHAR(100) NOT NULL,

    FOREIGN KEY (id) REFERENCES RegisteredUser(id),
    FOREIGN KEY (nameCompany) REFERENCES Company(name)
);

CREATE TABLE Customer(
    id          INT UNSIGNED PRIMARY KEY,
    address     TINYTEXT NOT NULL,
    country     TINYTEXT NOT NULL,
    phone       VARCHAR(50),

    FOREIGN KEY (id) REFERENCES RegisteredUser(id)
);

CREATE TABLE `Order`(
    orderNumber         CHAR(50) PRIMARY KEY,
    orderDate           TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    shippingDate        TIMESTAMP NULL,
    shippingAddress     TINYTEXT NOT NULL,
    shippingCountry     VARCHAR(50) NOT NULL,
    paymentType         VARCHAR(100) NOT NULL,
    paymentNumber       VARCHAR(100) NOT NULL,
    status              ENUM('PENDING','SHIPPED', 'DELIVERED') DEFAULT 'PENDING' NOT NULL,
    total               DOUBLE NOT NULL

);

CREATE TABLE Product(
    `name`              CHAR(100) NOT NULL PRIMARY KEY ,
    shortDescription    TINYTEXT NOT NULL,
    description         TEXT NOT NULL,
    brand               TINYTEXT NOT NULL,
    imageUrl            TINYTEXT NOT NULL,
    price               DOUBLE NOT NULL,
    stock               INT NOT NULL,

    -- Generalazziozne
    class               ENUM('Beer', 'Book', 'Monitor'),

    -- Beer
    ingredients         TEXT NULL           CHECK ((class = 'Beer') = (ingredients IS NOT NULL)),
    alcoholPercentage   DOUBLE NULL         CHECK ((class = 'Beer') = (alcoholPercentage IS NOT NULL)),
    liquidVolumeInML    DOUBLE NULL         CHECK ((class = 'Beer') = (liquidVolumeInML IS NOT NULL)),

    -- Book
    summary         MEDIUMTEXT NULL         CHECK ((class = 'Book') = (summary IS NOT NULL)),
    language        VARCHAR(50) NULL        CHECK ((class = 'Book') = (language IS NOT NULL)),
    numberPages     INT NULL                CHECK ((class = 'Book') = (numberPages IS NOT NULL)),

    -- Monitor
    screenSizeInches    DOUBLE NULL         CHECK ((class = 'Monitor') = (screenSizeInches IS NOT NULL)),
    displayResolutionX  INT UNSIGNED NULL   CHECK ((class = 'Monitor') = (displayResolutionX IS NOT NULL)),
    displayResolutionY  INT UNSIGNED NULL   CHECK ((class = 'Monitor') = (displayResolutionY IS NOT NULL)),
    specialFeatures     MEDIUMTEXT NULL     CHECK ((class = 'Monitor') = (specialFeatures IS NOT NULL)),
    refreshRateHz       DOUBLE NULL         CHECK ((class = 'Monitor') = (refreshRateHz IS NOT NULL))
);

CREATE TABLE ProductDetail(
    orderNumber CHAR(50) NOT NULL,
    nameProduct CHAR(100) NOT NULL,
    quantity    INT DEFAULT 0 NOT NULL,
    total       DOUBLE NOT NULL,

    FOREIGN KEY (orderNumber) REFERENCES `Order`(orderNumber),
    FOREIGN KEY (nameProduct) REFERENCES `Product`(`name`),
    PRIMARY KEY(orderNumber,nameProduct)
);
