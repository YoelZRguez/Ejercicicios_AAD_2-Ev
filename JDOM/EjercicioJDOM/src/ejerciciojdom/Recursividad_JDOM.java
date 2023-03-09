/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class Recursividad_JDOM {
    private SAXBuilder builder;
    private File xml;
    private Document documento;
    private static Element raiz;
    
    public Recursividad_JDOM(){
       try {
        builder = new SAXBuilder();
        xml = new File("concesionario.xml");        
        documento = (Document) builder.build(xml);
        raiz = documento.getRootElement();
        
        } catch (JDOMException ex) {
            Logger.getLogger(Recursividad_JDOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Recursividad_JDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static void main(String [] args){
        Recursividad_JDOM rj = new Recursividad_JDOM();
        rj.recursivo();
        /**
            System.out.println("Concesionario: "+raiz.getTextTrim());
            List <Element> modelo = raiz.getChildren();
            
            for (Element e : modelo){
                List <Element> modelo2 = e.getChildren();
                System.out.println("-------------------------------------------");
                System.out.println("Marca: "+e.getTextTrim());
                for (Element e2 : modelo2){
                    System.out.println(e2.getName()+":"+e2.getTextTrim());
                }
                
            }
    **/
        
    }
    
    public void recursivo() {
        List <Element> modelo = raiz.getChildren();
        
        for (int i = 0; i<modelo.size(); i++){
            if(!modelo.get(i).getChildren().isEmpty()){
                System.out.println(modelo.get(i).getName() + "="+modelo.get(i).getValue());
            }else{
                List <Element> hijo = modelo.get(i).getChildren();
                for (int j=0; j<hijo.size(); j++){
                    while(!hijo.get(i).getChildren().isEmpty()){
                        System.out.println("\n"+hijo.get(i).getName());
                        hijo = hijo.get(i).getChildren();                    
                    }
                    System.out.println("\n"+hijo.get(i).getValue());
                }
            }
        }        
        }
        
            }
        
     

