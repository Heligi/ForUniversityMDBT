SELECT manufacturer.NameManu, count(saleofcomponents.SalesCode) AS Число_покупок  
FROM manufacturer, accessories,saleofcomponents 
where manufacturer.codeManufacturer=accessories.codeManufacturer 
and accessories.AccessoryCode=saleofcomponents.AccessoryCode  
group by NameManu 
order by Число_покупок desc;