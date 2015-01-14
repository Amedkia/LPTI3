create database bd_form;
use bd_form;

create table tbl_datos(
id_usr int(10),
nombre varchar(50),
ap varchar(50),
am varchar(50),
enfermo varchar(2),
sexo varchar(20)
);



create table tbl_sex(
sex varchar(20)
);



#drop table tbl_datos;



delimiter //
create procedure sp_sexo()
begin

select * from tbl_sex as sex;
end //
delimiter ;


delimiter //
create procedure sp_llena_sexo (sexo_in nvarchar(20))
begin

INSERT INTO tbl_sex VALUES (sexo_in);

end //
delimiter ;

delimiter //
create procedure sp_alta(nombre_in nvarchar(50),ap_in nvarchar(50), am_in nvarchar(50),enfermo_in varchar(2),sexo_in nvarchar(20))
begin

declare id_usr_calc int(10);
declare existe int(2);

set existe = (select count(*) from tbl_datos where nombre = nombre_in and ap = ap_in and am = am_in);

	if existe = 0 then

		set id_usr_calc = (select ifnull(max(id_usr), 0) + 1 from tbl_datos);

		INSERT INTO tbl_datos VALUES (id_usr_calc,nombre_in,ap_in,am_in,enfermo_in,sexo_in);

		select id_usr_calc as id_getted;

	else

		select "Error" as id_getted;

	end if;

end //
delimiter ;

