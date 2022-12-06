CREATE DATABASE products;
go

USE products;
go

-- Drop all tables ignoring foreign key constraints
exec sp_MSforeachtable "declare @name nvarchar(max); set @name = parsename('?', 1); exec sp_MSdropconstraints @name";
exec sp_MSforeachtable "drop table ?";

-- DROP TABLE IF EXISTS prdocut;

DROP TABLE product;

CREATE TABLE product (
    productId               INT,
    productName             VARCHAR(40),
    partNumber              CHAR(4), 
    productLabel            CHAR(3),
    startingInventory       INT,
    inventoryReceived       INT,
    inventoryShipped        INT,
    inventoryOnHand         INT,
    minimumRequired         INT,
    PRIMARY KEY(productId, productName)
);

INSERT INTO product VALUES(0, 'Glass', '0000', 'X01', 500, 600, 200, 900, 400);
INSERT INTO product VALUES(1, 'Wood', '0001', 'X02', 600, 500, 300, 200, 100);
INSERT INTO product VALUES(2, 'Bricks', '0002', 'X03', 700, 245, 123, 535, 553);
INSERT INTO product VALUES(3, 'Polyester', '0003', 'X04', 1241, 345, 565, 324, 644);
INSERT INTO product VALUES(4, 'Vinyl', '0004', 'X05', 2343, 545, 123, 576, 157);
INSERT INTO product VALUES(5, 'Clay', '0005', 'X06', 655, 324, 675, 154, 234);
INSERT INTO product VALUES(6, 'Aluminum', '0006', 'X07', 712, 536, 874, 346, 654);
INSERT INTO product VALUES(7, 'Iron', '0007', 'X08', 956, 324, 675, 234, 745);
INSERT INTO product VALUES(8, 'Steel', '0008', 'X09', 1145, 534, 764, 354, 756);
INSERT INTO product VALUES(9, 'Plastic', '0009', 'X10', 1563, 1454, 254, 643, 836);