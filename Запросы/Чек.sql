select customer.FullName, (Amount*Price) AS Счёт
from customer, saleofcomponents,accessories
where customer.CodeCustomer=saleofcomponents.CodeCustomer
and accessories.AccessoryCode=saleofcomponents.AccessoryCode;