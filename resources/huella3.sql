/* drop database huella3 */
create database huella3
use huella3
select * from personal
select * from usuario
/*sp_helpdb huella
sp_help personal */
create table personal(
cod_per varchar(10) not null,
nombre varchar(30)not null,
apellido varchar(30)not null,
edad int not null,
celular varchar(9)not null,
correo varchar(50)not null,
foto image
)
/*cambiar solo una colomna */
alter table personal
alter column edad varchar(10) not null

create table ambulancia(
placa varchar(7)not null,
radio varchar(30)not null,
modelo varchar(30)not null,
color varchar(30)not null
)

create table hospital(
cod_hos varchar(30)not null,
departamento varchar(50)not null,
distrito varchar(50)not null,
direccion varchar(50)not null,
nombre_hos varchar(50)not null
)
/* agregar columna*/
alter table hospital
add provincia varchar(30) not null

alter table hospital
add clasificacion varchar(30) not null

alter table hospital
alter column clasificacion varchar(70) not null

create table reniec(
dni varchar(8)not null,
nombre varchar(30)not null,
apellido varchar(30)not null,
edad varchar(10)not null,
celular varchar(9)not null,
correo varchar(40)not null,
direccion varchar(50)not null,
foto image 
)

create table huella(
id varchar(50)not null,
puld IMAGE,
indd IMAGE,
medd image,
anud image,
meñd image,
puli IMAGE,
indi IMAGE,
medi image,
anui image,
meñi image,
dni varchar(8)not null
)

create table huella_2(
id int not null,
dedo IMAGE not null,
dni varchar(8)not null
)

create table contactos(
cod_con int not null,
nombre varchar(30)not null,
apellido varchar(30)not null,
tipo varchar(10)not null,
dni varchar(8)not  null
)
select * from contactos
alter table hospital
add provincia varchar(30) not null

alter table contactos
add correo varchar(50) not null

alter table contactos
add celular varchar(50) not null

create table usuario(
cod_usu varchar(10)not null,
contra1 varchar(20)not null,
contra2 image not null,
cod_per varchar(10)not null

)

create table horario(
cod_per varchar(10)not null,
placa varchar(7)not null,
hora_ini varchar(10)not null,
hora_fin varchar(10)not null,
dia_ini varchar(10)not null,
dia_fin varchar(10)not null,
cod_hos varchar(30)not null
)

 alter table horario
add cod_hor int not null



create table registro(
cod_re int not null,
hora_ing varchar(10)not null,
dia_ing varchar(10)not null,
dni varchar(8)not null,
cod_hos varchar(30)not null
)

 alter table registro
add hora_fin varchar(10) 

 alter table registro
add dia_fin varchar(10)

alter table registro
add enfermedad varchar(50)
/*
alter table cliente 
add constraint pk_cliente
primary key clustered (cod_c)
*/

alter table personal
add constraint pk_personal
primary key clustered (cod_per)

alter table ambulancia
add constraint pk_ambulancia
primary key clustered(placa)

alter table hospital
add constraint pk_hospital
primary key clustered(cod_hos)

alter table reniec 
add constraint pk_reniec
primary key clustered(dni)

/*
 alter table factura
 add constraint fk_factura
 foreign key (cod_c)
 references cliente(cod_c)
 */
 alter table huella
 add constraint pk_huella
 primary key clustered (id)

 alter table huella_2
 add constraint pk_huella_2
 primary key clustered (id)

 alter table huella
 add constraint fk_huella
 foreign key(dni)
 references reniec(dni)

 alter table huella_2
 add constraint fk_huella_2
 foreign key(dni)
 references reniec(dni)

 alter table contactos
 add constraint pk_contactos
 primary key clustered (cod_con)

 alter table contactos
 add constraint fk_contactos
 foreign key(dni)
 references reniec(dni)

 alter table usuario
 add constraint pk_usuario
 primary key clustered(cod_usu)

alter table horario 
add constraint pk_horario
primary key clustered(cod_per,placa,cod_hor)

alter table horario
add constraint fk1_horario
foreign key(cod_per)
references personal(cod_per)


alter table horario
add constraint fk2_horario
foreign key(placa)
references ambulancia(placa)

alter table horario
add constraint fk3_horario
foreign key (cod_hos)
references hospital(cod_hos)

alter table registro 
add constraint pk_registro
primary key clustered(cod_re)

alter table registro
add constraint fk1_registro
foreign key (dni)
references reniec(dni)

alter table registro 
add constraint fk2_registro
foreign key (cod_hos)
references hospital(cod_hos)
/* sp_help REGISTRO */
 select * from usuario
 select cod_usu,contra1,contra2,cod_per from usuario where cod_usu='bruno15'

 insert into usuario values('christian','p989414320','','1613744') 
 insert into usuario values('1613740','asd','','48525544') 
 select * from usuario
 select * from personal
select * from ambulancia
 select * from horario 
 select * from hospital
 
 select * from registro
 select * from huella
 select * from reniec
 select * from contactos
 /*Personal*/
 insert into personal values('48525544','Christian Bruno','Parrales Bringas','1994-07-15','989414320','parrales_el1@hotmail.com','') 
 insert into personal values('75128892','Carlos','Sanchez alvitez','1997-01-03','989414320','carl.sanalv@gmail.com','')
 insert into personal values('70838950','Johan alonzo','Espino Maldonado','1993-09-09','989414320','johanespino9@gmail.com','')


  /*Ambulancia*/
  insert into ambulancia values('ABC-123','SI','Toyota','rojo') 
  insert into ambulancia values('afp-678','SI','Toyota','blanco') 
  insert into ambulancia values('cjc-123','SI','Toyota','verde') 


   /*Hospital*/
    insert into hospital values('00004838','AMAZONAS','CHACHAPOYAS','HOSPITAL REGIONAL VIRGEN DE FATIMA','AV. PETTIT THOUARS 225','CHACHAPOYAS','HOSPITALES O CLINICAS DE ATENCION GENERAL')
	 insert into hospital values('00005044','AMAZONAS','BAGUA','AV. PETTIT THOUARS 225','APOYO BAGUA GUSTAVO LANATA','BAGUA','HOSPITALES O CLINICAS DE ATENCION GENERAL')
 insert into hospital values('00005145','AMAZONAS','NIEVA','AV. PETTIT THOUARS 225','SANTA MARIA DE NIEVA','CONDORCANQUI','HOSPITALES O CLINICAS DE ATENCION GENERAL')


  /*reniec*/
  insert into reniec values('48525544','Christian Bruno','Parrales Bringas','1994-07-15','989414320','parrales_el1@hotmail.com','Mz J Lt5 piso1 Los Jardines de Shangrila','') 
  insert into reniec values('75128892','Carlos','Sanchez alvitez','1997-01-03','929072821','carl.sanalv@gmail.com','Mz J Lt5 piso2 Los Jardines de Shangrila','') 
  insert into reniec values('70838950','Johan Alonzo','Espino Maldonado','1993-09-09','986647195','johanespino9@gmail.com','Mz J Lt5 piso3 Los Jardines de Shangrila','') 
  
   sp_help huella /**/

   insert into horario values('48525544','ABC-123','09:24:52','09:24:52','2018-02-05','2018-02-06','00004838',1) 
  insert into horario values('75128892','afp-678','10:50:25','10:50:25','2018-02-05','2018-02-06','00004838',2) 
  insert into horario values('70838950','cjc-123','01:05:01','01:05:01 ','2018-02-05','2018-02-06','00004838',3) 
/* delete from horario where cod_per='48525544'   */

/*
select * from registro
delete from registro where cod_re='6'
*/
insert into registro values('1','09:24:52','2018-02-05','48525544','00004838','10:24:52','2018-03-06','Bronquitis') 
  insert into registro values('2','07:24:52','2017-08-05','75128892','00005044','02:24:52','2017-08-06','Vph') 
  insert into registro values('3','05:24:52','2016-03-05','70838950 ','00005145','11:24:52','2016-03-09','Gonorrea')
   
  insert into registro values('4','10:24:52','2018-09-05','48525544','00005044','10:24:52','2018-09-10','Bulimia') 
  insert into registro values('5','12:24:52','2017-12-10','48525544','00005145','02:24:52','2018-08-06','Tos') 
    insert into registro values('6','10:24:52','2018-03-09','75128892','00005145','02:24:52','2018-03-09','VIH') 

  select * from personal
    select * from contactos
  /* Update personal set foto='asd' where cod_per='48525544' */
  insert into contactos values(1,'Ursula ','Bringas schraiber','Mama','48525544','johanespino9@gmail.com',989414320) 
  insert into contactos values(2,'Manuel Fernando','Parrales Agurto','Papa','48525544','parrales_el1@hotmail.com',989414320) 
  insert into contactos values(3,'Johan','Spino Maldonado','Amigo ','48525544','carl.sanalv@gmail.com',986647195) 
   insert into contactos values(4,'Carlos','Carru Campos','Amigo ','48525544','1613740@utp.edu.pe',929072821) 
 
 
   insert into contactos values(5,'Ursula ','Bringas schraiber','Mama','75128892','johanespino9@gmail.com',989414320) 
  insert into contactos values(6,'Manuel Fernando','Parrales Agurto','Papa','75128892','parrales_el1@hotmail.com',989414320) 
  insert into contactos values(7,'Johan','Spino Maldonado','Amigo ','75128892','carl.sanalv@gmail.com',986647195) 
   insert into contactos values(8,'Carlos','Carru Campos','Amigo ','75128892','1613740@utp.edu.pe',929072821) 
 
 insert into contactos values(9,'Ursula ','Bringas schraiber','Mama','70838950','johanespino9@gmail.com',989414320) 
  insert into contactos values(10,'Manuel Fernando','Parrales Agurto','Papa','70838950','parrales_el1@hotmail.com',989414320) 
  insert into contactos values(11,'Johan','Spino Maldonado','Amigo ','70838950','carl.sanalv@gmail.com',986647195) 
   insert into contactos values(12,'Carlos','Carru Campos','Amigo ','70838950','1613740@utp.edu.pe',929072821) 
  /* delete from contactos where cod_con=4*/
  select nombre,apellido,tipo,celular,correo from contactos where dni='48525544'
   select nombre,apellido,edad from reniec where dni='48525544'
   select nombre,apellido,tipo,celular from contactos where dni='48525544'

   select * from registro

 insert into huella values('1','','','','','','','','','','','48525544') 
   select ree.dia_ing,ree.hora_ing,ree.dia_fin,ree.hora_fin,hos.nombre_hos,ree.enfermedad
   from registro ree inner join hospital hos
   on hos.cod_hos=ree.cod_hos
   where ree.dni='48525544'
   select * from huella_2

