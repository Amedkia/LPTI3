/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "Imagenes")
public class Imagenes {

        
        @WebMethod(operationName = "datos")
        public String datos (@WebParam(name = "name") String name,@WebParam(name = "password") String pwd)
        {
            String msg = null;
             BD.Acceso sql = new BD.Acceso(); 
            try {            
                sql.conectar();
                ResultSet rs = sql.consulta("call sp_login('"+name+"','"+pwd+"')");
                
                if(rs.next())
                {
                    
                    String acces = rs.getString("login");
                    
                    
                    
                    if(acces.equals("1"))
                    {
                        msg="Bienvenido al sistema";
                    }
                    else
                    {
                        msg="Usuario no encontrado";
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            return msg;
        }
    
}
