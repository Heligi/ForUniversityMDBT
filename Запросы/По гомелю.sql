select manufacturer.NameManu AS Название_фирмы, accessories.NameAccessories AS Название_детали, stock.QuantityInStock AS Количество_деталей
from  stock, city, accessories, manufacturer
where 	stock.CodeCity=city.CodeCity
and manufacturer.codeManufacturer=accessories.codeManufacturer
and accessories.AccessoryCode=stock.AccessoryCode
and city.NameCity='Гомель';