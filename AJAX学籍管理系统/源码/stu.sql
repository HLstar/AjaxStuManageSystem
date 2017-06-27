create database ajax;
create table students(
					id int primary key auto_increment,
					name varchar(20) not null,
					stunum varchar(20) not null,
					gender varchar(10) not null,
					grade varchar(20) not null,
					academy varchar(20) not null, 
					profession varchar(40) not null
				);
insert into students values(null,"胡鑫男","14030210013","男","2014级","计算机学院","网络工程");
	insert into students values(null,"tom","17010010001","男","1997级","JAVA","WEB");
		insert into students values(null,"jsp","17010010002","男","1997级","JAVA","WEB");
			insert into students values(null,"jstl","17010010003","男","1997级","JAVA","WEB");
				insert into students values(null,"dtl","17010010004","男","1997级","JAVA","WEB");
					insert into students values(null,"dbutils","17010010005","男","1997级","JAVA","WEB");
						insert into students values(null,"ajax","17010010006","男","1997级","JAVA","WEB");
							insert into students values(null,"xml","17010010007","男","1997级","JAVA","WEB");
								insert into students values(null,"dta","17010010008","男","1997级","JAVA","WEB");