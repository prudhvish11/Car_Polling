show databases;
create database testing;
use testing;
create table logindetails(username varchar(20),Password varchar(20),role varchar(20));
create table pooldetails(name varchar(20),date Date, carno varchar(20), amount int, pickup varchar(20),destination varchar(20));
 
SELECT * FROM testing.logindetails;
SELECT * FROM testing.pooldetails;