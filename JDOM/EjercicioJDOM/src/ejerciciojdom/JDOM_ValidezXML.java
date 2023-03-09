package ejerciciojdom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class JDOM_ValidezXML {

    
    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("concesionario.xml");        
            Document documento = (Document) builder.build(xml);         
            Element raiz = documento.getRootElement();
            System.out.println(raiz.getTextTrim());
            
            List <Element> modelo = raiz.getChildren();
            
        for (Element e:modelo){
                List<Attribute> att = e.getAttributes();
                List <Element> modelo2 = e.getChildren();
                System.out.println("-------------------------------------------");
                System.out.println(e.getName()+":");
                for (int i = 0; i < att.size(); i++) {
                    System.out.println(att.get(i).getName()+" = " +att.get(i).getValue());
                }
                
                System.out.println("Marca: "+e.getTextTrim());
                for (Element e2 : modelo2){
                    System.out.println(e2.getName()+":"+e2.getTextTrim());
            }
        }
    
        } catch (JDOMException | IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
   
    
}
