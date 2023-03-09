package a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Mostrar_Profesores {
public static void main(String [] args){
            boolean sigue = true;
            SessionFactory sesion= HibernateUtil.getSessionFactory();
            Session session=sesion.openSession();
            Transaction tx=session.beginTransaction();
            
            Profesor pro = new Profesor();
            
            for(int i = 1; i<=7;i++){
               if(i<=9){
                 pro = (Profesor) session.get(Profesor.class, "0"+String.valueOf(i));  
               }else{
                   pro = (Profesor) session.get(Profesor.class, String.valueOf(i));
               }
               
               if(pro.getCiudad().compareTo("Avilés") == 0){
                    System.out.println("-----------------------------------------------");
                    System.out.println("Codigo de Profesor: "+pro.getCodProfesor());
                    System.out.println("Nombre de Profesor: "+pro.getNombreProfesor());
                    System.out.println("Ciudad: "+pro.getCiudad());
                    System.out.println("-----------------------------------------------");
               }
                
            }   
            
            session.save(pro);
            tx.commit();
            
            session.close();
            sesion.close();
            
    }
}

