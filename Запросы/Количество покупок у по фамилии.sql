select customer.FullName, count(customer.FullName)
from customer, saleofcomponents
where customer.CodeCustomer=saleofcomponents.CodeCustomer
group by customer.FullName;
