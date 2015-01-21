/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Alumno
 */
public class servlets {

    public String[] llena_combo(String raiz, String papa) {
        String[] value = null;

        try {
            URL url = new URL("http://localhost:8084/Servlets/xml?raiz=" + raiz + "&hijo=" + papa);
            
            System.out.println(url.toString());

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url.openStream());

//            String xxx = url.openStream().toString();
//            System.out.println(xxx);
            String xl = "";
            Element gob = doc.getDocumentElement();
            NodeList listaGenero = gob.getElementsByTagName(papa);
            //Recorrer la lista de listaGenero
            for (int i = 0; i < listaGenero.getLength(); i++) {

                xl += doc.getElementsByTagName(papa).item(i).getTextContent() + ",";

            }
            value = xl.split(",");

        } catch (MalformedURLException ex) {
            Logger.getLogger(servlets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(servlets.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

}
