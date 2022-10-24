
DROP IF EXISTS "unipi.eCommerce";
CREATE DATABASE "unipi.eCommerce";

USE "unipi.eCommerce";


-- tabelle

CREATE TABLE Company(
    name        VARCHAR(100) PRIMARY KEY,
    logoUrl     TINYTEXT NOT NULL,
    website     TINYTEXT NOT NULL

);

CREATE TABLE RegisteredUser(
    id             INT UNSIGNED PRIMARY KEY AUTOINCREMENT,
    firstName      VARCHAR(100) NOT NULL,
    lastName       VARCHAR(100) NOT NULL,
    username       VARCHAR(200) UNIQUE KEY NOT NULL,
    password       VARCHAR(255) NOT NULL,
    profilePicUrl  TINYTEXT NOT NULL,
    active         BOOLEAN DEFAULT TRUE NOT NULL,
    createdDate    TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updatedDate    TIMESTAMP DEFAULT 0 NOT NULL

);

CREATE TABLE Manager(
    id          INT UNSIGNED PRIMARY KEY,
    hiredDate   DATE DEFAULT CURRENT_DATE() NOT NULL,
    title       VARCHAR(200),
    nameCompany VARCHAR(100) NOT NULL,

    FOREIGN KEY (id) REFERENCES TO RegisteredUser(id),
    FOREIGN KEY (nameCompany) REFERENCES TO Company(name)
);

CREATE TABLE Customer(
    id          INT UNSIGNED PRIMARY KEY,
    address     TINYTEXT NOT NULL,
    country     TINYTEXT NOT NULL,
    phone       VARCHAR(50),

    FOREIGN KEY (id) REFERENCES TO RegisteredUser(id)
);

CREATE TABLE Order(
    orderNumber         CHAR(50) PRIMARY KEY,
    orderDate           TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    shippingDate        TIMESTAMP DEFAULT NULL,
    shippingAddress     TINYTEXT NOT NULL,
    shippingCountry     VARCHAR(50) NOT NULL,
    paymentType         VARCHAR(100) NOT NULL,
    paymentNumber       VARCHAR(100) NOT NULL,
    status              ENUM("PENDING","SHIPPED", "DELIVERED") DEFAULT "PENDING" NOT NULL,
    total               DOUBLE NOT NULL

);

CREATE TABLE Product(
    name                VARCHAR(100) NOT NULL,
    shortDescription    TINYTEXT NOT NULL,
    description         TEXT NOT NULL,
    brand               TINYTEXT NOT NULL,
    imageUrl            TINYTEXT NOT NULL,
    price               DOUBLE NOT NULL,
    stock               INT NOT NULL
);

CREATE TABLE ProductDetail(
    orderNumber CHAR(50),
    nameProduct VARCHAR(100),
    quantity    INT DEFAULT 0 NOT NULL,
    total       DOUBLE NOT NULL,

    FOREIGN KEY (orderNumber) REFERENCES TO Order(orderNumber),
    FOREIGN KEY (nameProduct) REFERENCES TO Product(name),
    PRIMARY KEY(orderNumber,nameProduct);
);

CREATE TABLE Beer(
    nameProduct         VARCHAR(100) PRIMARY KEY,
    ingredients         TEXT NOT NULL,
    alcoholPercentage   DOUBLE NOT NULL,
    liquidVolumeInML    DOUBLE NOT NULL,

    FOREIGN KEY (nameProduct) REFERENCES TO Product(name)
);

CREATE TABLE Book(
    nameProduct     VARCHAR(100) PRIMARY KEY,
    summary         MEDIUMTEXT NOT NULL,
    language        VARCHAR(50) NOT NULL,
    numberPages     INT NOT NULL,

    FOREIGN KEY (nameProduct) REFERENCES TO Product(name)
);

CREATE TABLE Monitor(
    nameProduct         VARCHAR(100) PRIMARY KEY,
    screenSizeInches    DOUBLE NOT NULL,
    displayResolutionX  INT UNSIGNED NOT NULL,
    displayResolutionY  INT UNSIGNED NOT NULL,
    specialFeatures     MEDIUMTEXT NOT NULL,
    refreshRateHz       DOUBLE NOT NULL,

    FOREIGN KEY (nameProduct) REFERENCES TO Product(name)
);

