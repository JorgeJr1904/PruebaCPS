USE cps;

CREATE TABLE fee(
idFee int not null IDENTITY(1,1) primary key,
region varchar(50) not null,
price smallmoney not null
);

CREATE TABLE type_client(
idTypeClient int identity(1,1) primary key not null,
vType varchar(30) not null,
discount int not null
);

CREATE TABLE client(
idClient int identity(1,1) primary key not null,
vName varchar(45) not null,
vLastname varchar(45) not null,
email varchar(50) not null,
vPassword varchar(300) not null,
idTypeClient int not null,
FOREIGN KEY (idTypeClient) REFERENCES type_client(idTypeClient)
);



INSERT INTO fee(region, price) values ('Norte America', 20);
INSERT INTO type_client(vType, discount) values ('Premium', 5);
