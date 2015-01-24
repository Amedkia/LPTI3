/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author system
 */
public class login {
    
    public boolean ingresa (String uss, String pwd)
    {
        boolean status = false;
        
        String XML = null;
        
        try{
        URL url = new URL("http://localhost:8080/calculadora_cosasraras/Login_Serv?usr="+uss+"&pwd="+pwd);
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url.openStream());
            
            Element gob = doc.getDocumentElement();
            NodeList listaGenero = gob.getElementsByTagName("log");
            //Recorrer la lista de listaGenero
            for (int i = 0; i < listaGenero.getLength(); i++) {

                XML = doc.getElementsByTagName("log").item(i).getTextContent();

            }
            
            status = "1".equals(XML);
                        
        }
        catch(ParserConfigurationException | IOException | SAXException e)
        {
            
        }
        
        return status;
    }
    
}
