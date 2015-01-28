create database aida_db;

use aida_db;


create table tbl_login(
id_usr int (10),
usr varchar(100),
pwd varchar(100),
aprobado int(2)
);


delimiter //
create procedure sp_alta(usr_in nvarchar(100),pwd_in nvarchar(100))

begin

declare id_usr_calc int(10);
declare aprobado_var int(2);

declare existe int(2);

set existe = (select count(*) from tbl_login where usr = usr_in);
set aprobado_var = 0;

	if existe = 0 then

		set id_usr_calc = (select ifnull(max(id_usr), 0) + 1 from tbl_login);

		INSERT INTO tbl_login VALUES (id_usr_calc,usr_in,pwd_in,aprobado_var);

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

create procedure sp_aprobar (usr_in nvarchar(100),pwd_in nvarchar(100))
begin

UPDATE tbl_login SET aprobado=1 where usr = usr_in and pwd = pwd_in;

select "Se ha validado el usuario" as login;
end //
delimiter ;

#DROP DATABASE aida_db;