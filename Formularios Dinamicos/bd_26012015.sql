create database bd_26012015;

use bd_26012015;


create table tbl_login(
id_usr int (10),
usr varchar(100),
pwd varchar(100),
apodo varchar(100)
);

create table tbl_form(
id_form int (20),
nombre varchar (100),
tipo int(10),
valor varchar(50),
id_formulario varchar(100)
);


delimiter //
create procedure sp_alta(usr_in nvarchar(100),pwd_in nvarchar(100),apodo_in nvarchar(100))
begin

declare id_usr_calc int(10);
declare existe int(2);

set existe = (select count(*) from tbl_login where usr = usr_in and apodo = apodo_in);

	if existe = 0 then

		set id_usr_calc = (select ifnull(max(id_usr), 0) + 1 from tbl_login);

		INSERT INTO tbl_login VALUES (id_usr_calc,usr_in,pwd_in,apodo_in);

		select id_usr_calc as id_getted;

	else

		select "Ya existe el usuario" as id_getted;

	end if;

end //
delimiter ;


delimiter //
create procedure sp_alta_formulario(nombre_in nvarchar(100),tipo_in nvarchar(100),valor_in nvarchar(100),id_formulario_in nvarchar(100))
begin

declare id_form_calc int(20);

declare existe int(2);

set existe = (select count(*) from tbl_form where id_formulario = id_formulario_in);

if existe = 0 then

		set id_form_calc = (select ifnull(max(id_form), 0) + 1 from tbl_form);

		INSERT INTO tbl_form VALUES (id_form_calc,nombre_in,tipo_in,valor_in,id_formulario_in);

		select id_form_calc as id_getted;
else

select "Ya existe el formulario" as id_getted;

end if;
	
end //
delimiter ;


delimiter //

create procedure sp_login (usr_in nvarchar(100),pwd_in nvarchar(100))
begin

declare resultado int(2);
set resultado = (select count(*) from tbl_login where usr = usr_in and pwd = pwd_in);

select resultado as login;
end //
delimiter ;
