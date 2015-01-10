call sp_altaimg(5,"Test","Acceso");

call sp_getimg(21);


select * from tbl_image;
delete from tbl_image where id_img = 21;