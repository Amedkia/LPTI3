create database aida_db;

use aida_db;


create table tbl_login(
id_usr int (10),
usr varchar(100),
pwd varchar(100),
nombre varchar(100),
ap varchar(100),
am varchar(100),
mail varchar(100),
nivel int(2),
aprobado int(2)
);


create table tbl_doc(
id_usr int (10),
nombre varchar(100),
url varchar(100),
fecha_reg timestamp,
fecha_limite varchar(50)

);

delimiter //

create procedure sp_getid (usr_in nvarchar(100),pwd_in nvarchar(100))
begin
declare id int(2);
set id = (SELECT id_usr FROM tbl_login WHERE usr = usr_in and pwd = pwd_in);

select id as id;
end //
delimiter ;


delimiter //
create procedure sp_alta(usr_in nvarchar(100),pwd_in nvarchar(100),nombre_in nvarchar(100),ap_in nvarchar(100),am_in nvarchar(100),mail_in nvarchar(100))

begin

declare id_usr_calc int(10);
declare aprobado_var int(2);
declare nivel_var int(2);
declare existe int(2);

set existe = (select count(*) from tbl_login where usr = usr_in);
set aprobado_var = 0;
set nivel_var=1;

	if existe = 0 then

		set id_usr_calc = (select ifnull(max(id_usr), 0) + 1 from tbl_login);

		INSERT INTO tbl_login VALUES (id_usr_calc,usr_in,pwd_in,nombre_in,ap_in,am_in,mail_in,nivel_var,aprobado_var);

		select "Registro exitoso con id:" + id_usr_calc as id_getted;

	else

		select "Ya existe el usuario" as id_getted;

	end if;

end //
delimiter ;


delimiter //

create procedure sp_login (usr_in nvarchar(100),pwd_in nvarchar(100))
begin

declare resultado int(2);
set resultado = (select count(*) from tbl_login where usr = usr_in and pwd = pwd_in and aprobado = 1);

select resultado as login;
end //
delimiter ;

delimiter //

create procedure sp_aprobar (usr_in nvarchar(100))
begin

UPDATE tbl_login SET aprobado=1 where usr = usr_in;

select "Se ha validado el usuario" as login;
end //
delimiter ;

delimiter //

create procedure sp_nivel (usr_in nvarchar(100),nivel_in int(2))
begin

UPDATE tbl_login SET nivel=nivel_in where usr = usr_in;

select "Se ha modificado el tipo de usuario a nivel" + nivel_in as login;
end //
delimiter ;

delimiter //

create procedure sp_alta_doc (usr_in nvarchar(100),pwd_in nvarchar(100),nombre_doc_in nvarchar(100))
begin

declare id_usr_calc int(10);
declare url varchar(100);

set url = (concat('http://localhost:56195/AIDA/files/',nombre_doc_in));
set id_usr_calc = (SELECT id_usr FROM tbl_login WHERE usr = usr_in and pwd = pwd_in);

INSERT INTO tbl_doc VALUES (id_usr_calc,nombre_doc_in,url,current_time,null);

select "ok" as ok;
end //
delimiter ;

#DROP DATABASE aida_db;