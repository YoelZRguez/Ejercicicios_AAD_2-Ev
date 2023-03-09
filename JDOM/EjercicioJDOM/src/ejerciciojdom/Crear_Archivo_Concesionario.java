/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Crear_Archivo_Concesionario {
    public static void main(String[] args){
        try {
        Element concesionario = new Element("Concesionario");
        Document documento = new Document(concesionario);
        
        Element coches = new Element("Coches");
        concesionario.addContent(coches);
        
        Element coche = new Element("coche");
        coches.addContent(coche);
        Element matriculaCoche = new Element("matricula");
        matriculaCoche.setText("1234hyu");
        coche.addContent(matriculaCoche);
        Element marcaCoche = new Element("marca");
        marcaCoche.setText("Audi");
        coche.addContent(marcaCoche);
        Element precioCoche = new Element("precio");
        precioCoche.setText("3500");
        coche.addContent(precioCoche);
        
        Element coche2 = new Element("coche");
        coches.addContent(coche2);
        Element matriculaCoche2 = new Element("matricula");
        matriculaCoche2.setText("1111aaa");
        coche2.addContent(matriculaCoche2);
        Element marcaCoche2 = new Element("marca");
        marcaCoche2.setText("Ford");
        coche2.addContent(marcaCoche2);
        Element precioCoche2 = new Element("precio");
        precioCoche2.setText("5000");
        coche2.addContent(precioCoche2);
        
        Element coche3 = new Element("coche");
        coches.addContent(coche3);
        Element matriculaCoche3 = new Element("matricula");
        matriculaCoche3.setText("4444ggg");
        coche3.addContent(matriculaCoche3);
        Element marcaCoche3 = new Element("marca");
        marcaCoche3.setText("Seat");
        coche3.addContent(marcaCoche3);
        Element precioCoche3 = new Element("precio");
        precioCoche3.setText("3500");
        coche3.addContent(precioCoche3);
        
        XMLOutputter xml = new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat());
        
        xml.output(documento, new FileWriter("concesionario.xml"));
        
        } catch (IOException ex) {
            Logger.getLogger(Crear_Archivo_XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

