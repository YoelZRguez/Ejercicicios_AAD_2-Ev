package hibernatehql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HibernateHQL {

    
    public static void main(String[] args) {
            SessionFactory sesion=HibernateUtil.getSessionFactory();
            Session session=sesion.openSession();
            Transaction tx=session.beginTransaction();
        
            String hql = "INSERT INTO Profesor(codProfesor, nombreProfesor, ciudad)"
            + " SELECT p.codProfesor, p.nombreProfesor,p.ciudad FROM Profesor2 p";
            Query cons = session.createQuery(hql);
            cons.executeUpdate();
            
            tx.commit();
            session.close();
            sesion.close();
            
    }
    
}
