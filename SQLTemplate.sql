create table studenter (
ID INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
namn varchar(256) not null
);

create table kurser(
ID INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),  
namn varchar (256) not null
);



create table betyg(
kursid int not null,
studentid int not null, 
betyg varchar (4),
primary key (kursid, studentid),
foreign key (kursid) references kurser(id),
foreign key (studentid) references studenter(id)
);

create table grouptable(
userid varchar(256) not null primary key,
groupid varchar(256) not null
 );

create table users(
userid varchar(256) not null,
password varchar(256) not null, 
primary key(userid, password)
);