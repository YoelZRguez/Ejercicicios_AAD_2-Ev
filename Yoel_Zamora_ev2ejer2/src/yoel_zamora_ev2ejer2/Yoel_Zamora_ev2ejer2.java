package yoel_zamora_ev2ejer2;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Yoel_Zamora_ev2ejer2 {

    
    public static void main(String[] args) {
        try {
       String campo;
       String valor;
       String campoFinal="";
       int numeroMayor = 0;
       
       SAXBuilder builder = new SAXBuilder();
       File xml = new File("fruta.xml");        
       Document documento = (Document) builder.build(xml);
       Element raiz = documento.getRootElement();
       List <Element> elementos = raiz.getChildren();
       
       for(Element e: elementos){
           List <Attribute> att = e.getAttributes();
           for (Attribute atributo: att){
               campo = atributo.getName();
               valor = atributo.getValue();
               if(numeroMayor < Integer.parseInt(valor)){
                   campoFinal = campo;
                   numeroMayor = Integer.parseInt(valor);
               }
           }
       }
            System.out.println("Alimento con el atributo más alto: "+campoFinal+" = "+numeroMayor);
       
        } catch (JDOMException  | IOException e) {
            e.getMessage();
        }
       
    }
    
}
