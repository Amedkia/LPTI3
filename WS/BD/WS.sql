create database WS_2015;
use WS_2015;

create table tbl_image(
id_img int(10),
id_usr int(10),
nombre_img varchar(100),
estatus varchar(20));

#desc tbl_image;

create table tbl_user(
id_usr int(10),
uss varchar(50),
pwd varchar(100),
nombre varchar(20),
fecha timestamp
);

#drop table tbl_user;

desc tbl_user;

delimiter //
create procedure sp_altaimg (id_usr_in nvarchar(50),nombre_img_in nvarchar(100),estatus_in nvarchar(20))
begin
declare id_image int(10);

set id_image = (select ifnull(max(id_img), 0) + 1 from tbl_image);

INSERT INTO tbl_image VALUES (id_image,id_usr_in,nombre_img_in,estatus_in);

select id_image as id_getted;
end //
delimiter ;

delimiter //
create procedure sp_getimg (id_img_in int (10))
begin

SELECT * FROM tbl_image WHERE id_img=id_img_in;

end //
delimiter ;

delimiter //
create procedure sp_deleteimg (id_img_in int (10))
begin

DELETE FROM tbl_image WHERE id_img=id_img_in;

end //
delimiter ;

delimiter //
create procedure sp_altausuario (uss_in nvarchar(50), pwd_in nvarchar(100), nombre_in nvarchar(20))
begin

declare id_user int(10);
declare existe int(2);

set existe = (select count(*) from tbl_user where uss = uss_in);
 
        if existe = 0 then
			set id_user = (select ifnull(max(id_usr), 0) + 1 from tbl_user);
            INSERT INTO tbl_user VALUES (id_user,uss_in,pwd_in,nombre_in,current_time);
            select id_user as id_getted;
            
            else
            
            select "Error" as msj;
            
            end if;

end //
delimiter ;



delimiter //
create procedure sp_login (uss_in nvarchar(50), pwd_in nvarchar(100))
begin

declare existe int(2);

set existe = (select count(*) from tbl_user where uss = uss_in and pwd = pwd_in);

	if existe = 1 then
		select 1 as login;
    else
		select 0 as login;
    end if;

end //
delimiter ;


#drop procedure sp_altausuario;
#drop procedure sp_login;
#drop procedure sp_altaimg;
