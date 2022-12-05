USE MASTER;
if DB_ID('MAIB_Autentification') IS NOT NULL BEGIN
DECLARE @SQL varchar(max)

SELECT @SQL = COALESCE(@SQL,'') + 'Kill ' + Convert(varchar, SPId) + ';'
FROM MASTER..SysProcesses
WHERE DBId = DB_ID('MAIB_Autentification') AND SPId <> @@SPId

EXEC(@SQL)
	DROP DATABASE MAIB_Autentification;
END
GO
create database MAIB_Autentification
GO
use MAIB_Autentification
create table authentication(
    ID_				bigint IDENTITY primary key ,
    username_		varchar(30),
	password_		varchar(30),
)





insert into authentication values
('user','user'),
('qwerty','qwerty!')

select * from authentication
