create database aida_db;

use aida_db;


create table tbl_login(
id_usr int (10),
usr varchar(100),
pwd varchar(100)
);


delimiter //
create procedure sp_alta(usr_in nvarchar(100),pwd_in nvarchar(100))

begin

declare id_usr_calc int(10);
declare existe int(2);

set existe = (select count(*) from tbl_login where usr = usr_in);

	if existe = 0 then

		set id_usr_calc = (select ifnull(max(id_usr), 0) + 1 from tbl_login);

		INSERT INTO tbl_login VALUES (id_usr_calc,usr_in,pwd_in);

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
set resultado = (select count(*) from tbl_login where usr = usr_in and pwd = pwd_in);

select resultado as login;
end //
delimiter ;
