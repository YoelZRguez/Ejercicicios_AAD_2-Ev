package Clases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class LeerXML_BBDD {
    private SAXBuilder builder;
    private File xml;
    private Document documento;
    private Element raiz;
    private List <Element> modelo;
    private Profesor p;
    private SessionFactory sesion;
    private Session session;
    private Transaction tx;
    
    public LeerXML_BBDD(){
        try {
        builder = new SAXBuilder();
        xml = new File("profesor.xml");        
        documento = (Document) builder.build(xml);
        raiz = documento.getRootElement();
        modelo = raiz.getChildren();
        sesion= HibernateUtil.getSessionFactory();
        session=sesion.openSession();
        tx = session.beginTransaction();
        
        
        p = new Profesor();
        
    } catch (IOException | JDOMException ex) {
            ex.getMessage();
    }  
    }
    
    public static void main(String [] args){
        LeerXML_BBDD l = new LeerXML_BBDD();
        l.recursivo();
        
    }
    
    private void recursivo() {
        
        for(Element e: modelo){    
            String nombre = e.getName().toLowerCase();
            System.out.println(nombre);
            if(nombre.compareTo("alumno") == 0 || 
                nombre.compareTo("profesor") == 0||
                nombre.compareTo("alumno_modulo") == 0 ||
                nombre.compareTo("ciclo") == 0 ||
                nombre.compareTo("modulo") == 0){
                
               
                modelo = e.getChildren();
                añadirBBDD(nombre);
                
            }else{
                modelo = e.getChildren();
                recursivo();
        }
        
    }   tx.commit();
        session.close();
        sesion.close();
        
        }
    
    private void añadirBBDD(String tabla){
        switch (tabla){
            case "alumno":

                break;
                
            case "profesor":
                for(Element e: modelo){
                    String campo = e.getName().toLowerCase();
                    String valor = e.getValue().toLowerCase();
                    profesor(valor, campo);   
                }
                session.save(p);

                break;
                
            case "alumno_modulo":
                
                break;
                
            case "ciclo":
                
                break;
                
            case "modulo":
                
                break;
        }
        
    }
        
        
    
    
    private void profesor(String valor, String campo){
        switch(campo){
            case "cod_profesor":
                p.setCodProfesor(valor);
                break;
                
            case "nombre_profesor":
                p.setNombreProfesor(valor);
                break;
                
            case "ciudad":
                p.setCiudad(valor);
                break;
            
            default:
                System.out.println("Nada");
                break;
        }
                
    }
}
    

