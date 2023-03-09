package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

    public class Hibernate1 {
        public static void main(String[] args) {
            SessionFactory sesion=HibernateUtil.getSessionFactory();
            Session session=sesion.openSession();
            Transaction tx=session.beginTransaction();
            
            System.out.println("Insertaremos un profesor: ");
            Profesor pro = new Profesor();
            pro.setCodProfesor("34");
            pro.setNombreProfesor("Pepe");
            pro.setCiudad("Pola de Siero");
            
            session.save(pro);
            tx.commit();
            
            session.close();
            sesion.close();
        }
    
    }
