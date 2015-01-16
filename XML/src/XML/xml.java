/*
 * Copyright (C) 2015 Alumno
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package XML;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class xml {
    
    public String[] llena ()
    {
        String[] datos = null;
        
        
                //Llenado dinamico del comboBox
        String valor = "";
        try {
            BD.cDatos base = new BD.cDatos();
            base.conectar();

            ResultSet rs = base.consulta("call sp_sexo");

            while (rs.next()) {
                valor += rs.getString("sex") + ",";
            }

            datos = valor.split(",");

           
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: "+ex.toString());
        }

        //Termina llenado de combo...
        
        return datos;
    }
    
}
