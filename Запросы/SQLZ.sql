-- select * from users;
-- insert into users (UsersName, Password) values ('Vova', 'root');
/*
SELECT UsersName,Password 
FROM users
WHERE (UsersName='Kola')and(Password='root'); */

-- select * from manufacturer;
-- insert into manufacturer (codeManufacturer,NameManu) values(1,'HP');

-- select * from customer;
-- insert into customer (CodeCustomer, FullName, Address) values (1, 'Pete Pavlov', 'Gagarina 22');

--  SELECT * FROM new_schema.accessories;
-- insert into accessories(AccessoryCode, codeManufacturer, NameAccessories, Price) values (1,1,'processor',200);

-- SELECT * FROM new_schema.saleofcomponents;
-- insert into saleofcomponents(SalesCode,codeManufacturer,Amount,CodeCustomer) values (1,1,1,1);

-- update customer set FullName='Pavlov_R.T.', Address='Gagarina_22' where CodeCustomer=1;