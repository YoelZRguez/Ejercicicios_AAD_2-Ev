/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author YoelZR
 */
public class Crear_Archivo_XML {
    
    public static void main(String[] args){
        try {
        Element pais = new Element("pais");
        Document documento = new Document(pais);
        
        pais.setAttribute("nombre" , "Suiza");
        pais.setAttribute("rio","Nilo");
        
        Element comunidad1 = new Element("comunidad");
        comunidad1.setText("Asturias");
        pais.addContent(comunidad1);
        
        Element comunidad2 = new Element("comunidad");
        comunidad2.setText("Murcia");
        pais.addContent(comunidad2);
        
        XMLOutputter xml = new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat());
        
        xml.output(documento, new FileWriter("pais.xml"));
        
        } catch (IOException ex) {
            Logger.getLogger(Crear_Archivo_XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
