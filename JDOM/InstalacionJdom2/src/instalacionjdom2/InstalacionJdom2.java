package instalacionjdom2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.Element;

public class InstalacionJdom2 {
  
    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("concesionario.xml");        
            Document documento = (Document) builder.build(xml);         
            Element raiz = documento.getRootElement();
            System.out.println(raiz);
            System.out.println(raiz.getName());
            Element coche;
            List<Element> valores_coches;
            List<Element> listaCoches = raiz.getChildren("coches");
            for (int i = 0; i<listaCoches.size(); i++){
                coche = listaCoches.get(i);
                valores_coches = coche.getChildren();
                System.out.println("Matricula \t Marca \t Precio");
                System.out.println("_______________________________");
                for (int j = 0; j<valores_coches.size(); j++){
                    /*
                    * Elemet campo = valores_coches.get(j);
                    * String matricula = campo.getChilTexTrim("matricula");
                    * String marca = campo.getChilTexTrim("marca");
                    * String precio = campo.getChilTexTrim("precio");
                    * System.out.println(matricula + " \t " + marca +  " \t " + precio);
                    */
                    System.out.println(valores_coches.get(j).getChildText("matricula") + " \t " + valores_coches.get(j).getChildText("marca") + " \t " + valores_coches.get(j).getChildText("precio"));
                }
            }
        } catch (JDOMException | IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}