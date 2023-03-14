package Clases;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
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
    private List <Element> modelo, modelo2;
    private SessionFactory sesion;
    private Session session;
    private Transaction tx;
    
    public LeerXML_BBDD(){
        try {
        builder = new SAXBuilder();
        xml = new File("BBDD.xml");        
        documento = (Document) builder.build(xml);
        raiz = documento.getRootElement();
        modelo = raiz.getChildren();
        sesion= HibernateUtil.getSessionFactory();
        session=sesion.openSession();
        tx = session.beginTransaction();
        
        
        
        
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
               
                modelo2 = e.getChildren();
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
                Alumno al = new Alumno();
                for(Element e: modelo2){
                    String campo = e.getName().toLowerCase();
                    String valor = e.getValue();
                    alumno(valor, campo,al);   
                }
                session.save(al);
                break;
                
            case "profesor":
                Profesor p = new Profesor();
                for(Element e: modelo2){
                    String campo = e.getName().toLowerCase();
                    String valor = e.getValue();
                    profesor(valor, campo,p);   
                }
                session.save(p);
                break;
                
            case "ciclo":
                Ciclo c = new Ciclo();
                for(Element e: modelo2){
                    String campo = e.getName().toLowerCase();
                    String valor = e.getValue();
                    ciclo(valor, campo,c);   
                }
                session.save(c);
                break;
                
            case "modulo":
                Modulo m = new Modulo();
                for(Element e: modelo2){
                    String campo = e.getName().toLowerCase();
                    String valor = e.getValue();
                    modulo(valor, campo,m);   
                }
                session.save(m);
                break;
        }
        
    }
        
        private void ciclo(String valor, String campo, Ciclo c){
        switch(campo){
            case "cod_ciclo":
                c.setCodCiclo(valor);
                break;
                
            case "nombre":
                c.setNombre(valor);
                break;
                
            case "grado":
                c.setGrado(valor);
                break;
            
            default:
                System.out.println("Nada");
                break;
        }
                
    }
        
        private void modulo(String valor, String campo, Modulo m){
        switch(campo){
            case "cod_modulo":
                m.setCodModulo(valor);
                break;
                
            case "nombre_modulo":
                m.setNombreModulo(valor);
                break;
                
            case "cod_ciclo":
                Ciclo c;
                c = (Ciclo) session.get(Ciclo.class, String.valueOf(valor));
                m.setCiclo(c);
                break;
                
             case "cod_profesor":
                Profesor p;
                p = (Profesor) session.get(Profesor.class, String.valueOf(valor));
                m.setProfesor(p);
                break;
                
            case "curso":
                m.setCurso(valor);
                break;
            
            default:
                System.out.println("Nada");
                break;
        }
                
    }
    
    
    private void profesor(String valor, String campo, Profesor p){
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
    
    private void alumno(String valor, String campo, Alumno al){
        switch(campo){
            case "cod_alumno":
                al.setCodAlumno(valor);
                break;
                
            case "nombre_alumno":
                al.setNombreAlumno(valor);
                break;
                
            case "apellidos_alumno":
                al.setApellidosAlumno(valor);
                break;
                
                case "grupo":
                al.setGrupo(valor);
                break;
                
            case "fecha_nacimiento":
                Date fecha = Date.valueOf(valor);
                al.setFechaNacimiento(fecha);
                break;
            
            default:
                System.out.println("Nada");
                break;
        }
                
    }
}
    

