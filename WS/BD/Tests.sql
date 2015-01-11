call sp_altaimg(5,"Test","Acceso");

call sp_getimg(1);

call sp_deleteimg(1);

call sp_altausuario("jerry2","123","Misa");

call sp_login('jerry2','123');

select * from tbl_user;


