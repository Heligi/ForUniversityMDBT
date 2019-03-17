CREATE TRIGGER audit AFTER  update  
ON new_schema.saleofcomponents FOR EACH ROW 
INSERT INTO new_schema.ddl_log 
SET 
Log_Time=GETDATE(), 
Log_Name=('date(//UserName [1]', 'nvrchat (max)'),  
Log_Login=('date(//LoginName [1]', 'nvrchat (max)'), 
Log_Even=('date(//EventType [1]', 'nvrchat (max)'), 
Log_Command=('date(//CommandText [1]', 'nvrchat (max)')
DELIMITER ;
