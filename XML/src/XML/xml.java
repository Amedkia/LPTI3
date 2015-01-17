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

import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Alumno
 */
public class xml {

    public String[] creaXML() {

        String[] datos = null;
        try {
            DocumentBuilderFactory creadorXML = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = creadorXML.newDocumentBuilder();
            Document documento;

            String strXML = "";
            try {
                BD.cDatos base = new BD.cDatos();
                base.conectar();

                ResultSet rs = base.consulta("call sp_sexo");

                strXML += "<raiz>";

                while (rs.next()) {
                    strXML += "<genero>" + rs.getString("sex") + "</genero>";
                }
                strXML += "</raiz>";

                //Me crea un hermoso String que parece XML
                System.out.println(strXML);

                String xl = "";
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(strXML));
                documento = creadorDocumento.parse(is);

                Element raiz = documento.getDocumentElement();
                NodeList listaGenero = raiz.getElementsByTagName("genero");
                //Recorrer la lista de listaGenero
                for (int i = 0; i < listaGenero.getLength(); i++) {

                    xl += documento.getElementsByTagName("genero").item(i).getTextContent() + ",";

                }
                datos = xl.split(",");

                //AGREGADOO
            } catch (SAXException ex) {
                System.out.println("SAXException: " + ex.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return datos;

    }

//    public String[] llenaCombo() {
//        String[] datos = null;
//
//        //Llenado dinamico del comboBox
//        String valor = "";
//        try {
//            BD.cDatos base = new BD.cDatos();
//            base.conectar();
//
//            ResultSet rs = base.consulta("call sp_sexo");
//
//            while (rs.next()) {
//                valor += rs.getString("sex") + ",";
//            }
//
//             datos = valor.split(",");
//
//        } catch (SQLException ex) {
//            System.out.println("SQL ERROR: " + ex.toString());
//        }
//
//        //Termina llenado de combo...
//        return datos;
//    }
}
