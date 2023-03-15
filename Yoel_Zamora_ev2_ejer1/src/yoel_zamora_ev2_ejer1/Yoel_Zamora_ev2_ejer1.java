package yoel_zamora_ev2_ejer1;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Yoel_Zamora_ev2_ejer1 {

    public static void main(String[] args) {
        int contador = 0;
        
        SessionFactory sesion=HibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Transaction tx=session.beginTransaction();
        
        String hql = "FROM Profesor p WHERE p.ciudad='Avilés' OR p.ciudad='Gijón'";
        Query cons = session.createQuery(hql);
        List <Profesor> list = cons.list();
        
        for (Profesor p:list){
            System.out.println("----------------------------------------------------");
            System.out.println(p.getCodProfesor());
            System.out.println(p.getNombreProfesor());
            System.out.println(p.getCiudad());
            System.out.println("----------------------------------------------------");
            contador++;
        }
        
        System.out.println("Número de profesores de Avilés o Gijón: "+contador);
        tx.commit();
        session.close();
        sesion.close();
        
        
        
    }
    
}
