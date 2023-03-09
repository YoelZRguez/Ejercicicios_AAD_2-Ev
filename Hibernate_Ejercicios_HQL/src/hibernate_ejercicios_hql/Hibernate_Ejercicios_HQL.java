package hibernate_ejercicios_hql;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Hibernate_Ejercicios_HQL {

    
    Scanner sc = new Scanner (System.in);
    SessionFactory sesion;
    Session session;
    Transaction tx;
    
    public Hibernate_Ejercicios_HQL(){
            sesion= HibernateUtil.getSessionFactory();
            session=sesion.openSession();
            tx=session.beginTransaction();
    }
    
    public static void main(String[] args) {
        Hibernate_Ejercicios_HQL a = new Hibernate_Ejercicios_HQL();
        a.iniciarPrograma();
    }
    
    private void iniciarPrograma(){
        int opcion = 0;
        do{
        opcion = menu();
        procesarOpcion(opcion);
        }while(opcion!=0);
    }
    private int menu(){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Introduce la opción que deseas ejecutar: "
                + "\n1. Borrar un elemento de la tabla profesor introduciendo por teclado la columna y el dato para eliminar el registro."
                + "\n2. Actualizar un registro de la tabla profesor, introduciendo los datos por teclado)"
                + "\n3. Mostrar por pantalla todos los alumnos)"
                + "\n4. Mostrar por pantalla nombre de profesor, apellidos y nombre del módulo"
                + "\n0. Salir");
        System.out.print("> ");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------------------------------------------------------");
        return opcion;
    }
    
    private void procesarOpcion(int opcion){
        switch (opcion){
                case 1: 
                    borrarProfesor();
                    break;
                    
                case 2: 
                    actualizarProfesor();
                    break;
                    
                case 3: 
                    mostrarAlumnos();
                    break;
                    
                case 4:
                    mostrarProfesor();
                    break;
                    
                case 0: 
                    System.out.println("Finalizando el programa...");
                    session.close();
                    sesion.close();
                    break;
                    
                default: 
                    System.out.println("No está permitda la opción elegida");
                    break;
        }
    
    }
    
    private String IntroducirCampoProfesor(String campo, String campo2,String dato1,String dato2){
        String otro = "", hql ="";

        do{
            System.out.println("Introduce el campo que quieres elegir para eliminar el/los profesores: ");
            System.out.print("> ");
            campo = sc.nextLine();
            }while(!campo.equals("cod_profesor")  && !campo.equals("nombreProfesor") && !campo.equals("ciudad"));
            
            System.out.println("Introduce el dato que deseas eliminar: ");
            System.out.print("> ");
            dato1 = sc.nextLine();
            
            do{
            System.out.println("¿Quiere introducir otro campo? (y/n)");
            System.out.print("> ");
            otro = sc.nextLine();    
            }while(!otro.equals("y") && !otro.equals("n"));
            
            if(otro.equals("y")){
            do{
                System.out.println("Introduce el segundo campo: ");
                System.out.print("> ");
                campo2=sc.nextLine(); 
            }while(!campo2.equals(campo) &&  campo2.equals("cod_profesor") ||
                   !campo2.equals(campo) &&  campo2.equals("nombreProfesor")||
                   !campo2.equals(campo) &&  campo2.equals("ciudad"));
            
            System.out.println("Introduce el segundo dato que deseas eliminar: ");
            System.out.print("> ");
            dato2 = sc.nextLine();
            hql = "DELETE FROM Profesor WHERE "+campo+"='"+dato1+"' AND "+campo2+"='"+dato2+"'";
            }else{
            hql = "DELETE FROM Profesor WHERE "+campo+"='"+dato1+"'";
            }
            
            return hql;
    }
    
    private void borrarProfesor(){
            String campo="",campo2="",dato1="",dato2="", hql ="";
            
            System.out.println("Campos disponibles : "
                    + "\n-cod_profesor"
                    + "\n-nombreProfesor"
                    + "\n-ciudad");
            
            hql = IntroducirCampoProfesor(campo,campo2,dato1,dato2);
            Query cons = session.createQuery(hql);
            cons.executeUpdate();
            tx.commit();
    }
    
    private void actualizarProfesor(){
        String hql="";
        
        System.out.println("Introduce el cod_profesor que deseas modificar: ");
        System.out.print("> ");
        String cod_profesor = sc.nextLine();
        
        System.out.println("Introduce el nuevo nombre del profesor: ");
        System.out.print("> ");
        String nombreProfesor = sc.nextLine();
        
        System.out.println("Introduce la nueva ciudad del profesor: ");
        System.out.print("> ");
        String ciudad = sc.nextLine();
        
        hql = "UPDATE Profesor p SET p.ciudad='"+ciudad+"' , p.nombreProfesor='"+nombreProfesor+"' WHERE p.codProfesor='"+cod_profesor+"'";
        
        Query cons = session.createQuery(hql);
        cons.executeUpdate();
        tx.commit();
    }
    
    private void mostrarAlumnos(){
        
        String hql = "from Alumno";
        Query cons = session.createQuery(hql);
        List list = cons.list();
        Iterator i = list.iterator();
        
        while(i.hasNext()){
            System.out.println(i.next().toString());
        }
        
        tx.commit();
    }
    
    private void mostrarProfesor(){
        String hql = "select m.nombreModulo, prof.nombreProfesor from Modulo m INNER JOIN m.profesor as prof ";
        Query cons = session.createQuery(hql);
        List <?> results = cons.list();
        Iterator it = results.iterator();
        
        for (int i = 0; i < results.size(); i++) {
            Object [] row = (Object[]) results.get(i);
            System.out.println("Nombre Modulo: "+row[0]+", Nombre Profesor: "+row[1]);
        }
        
        tx.commit();
    
    }
    
    
    
}
