create table medicine(medicine_id int primary key auto_increment, medicine_name varchar(30) not null,company varchar(30) not null ,manufacturedate date not null,expiredate date not null,amount int not null) auto_increment=101;

insert  into medicine values('Zinase-S','Cipla','2020-09-16','2022-07-16',1203);
insert  into medicine values('Param32','Aurobindo Pharma','2020-09-10','2023-11-27',305);
insert  into medicine values('Zinase-D','Abbott India','2020-09-10','2020-09-10',120);
insert  into medicine values('Digen','Cipla','2020-05-16','2022-01-16',122);
