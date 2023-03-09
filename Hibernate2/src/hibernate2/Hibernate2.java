/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate2;

import java.sql.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Hibernate2 {
     private static Scanner sc = new Scanner (System.in);
      
    public static void main(String[] args) {
        boolean diaValido = false, mesValido = false, añoValido=false;
        String fecha ="";
        String año="", mes="", dia="";
        
            SessionFactory sesion=NewHibernateUtil.getSessionFactory();
            Session session=sesion.openSession();
            Transaction tx=session.beginTransaction();
            
            System.out.println("Insertaremos un alumno: ");
            Alumno al = new Alumno();
            
            System.out.println("Inserte el cod_alumno: ");
            System.out.print("> ");
            String cod_alumno = sc.nextLine();
            al.setCodAlumno(cod_alumno);
            
            
            System.out.println("Inserte el nombre del alumno: ");
            System.out.print("> ");
            String nombre = sc.nextLine();
            al.setNombreAlumno(nombre);
            
            System.out.println("Inserte los apellidos del alumno: ");
            System.out.print("> ");
            String apellidos = sc.nextLine();
            al.setApellidosAlumno(apellidos);
            
            System.out.println("Inserte el grupo del alumno: ");
            System.out.print("> ");
            String grupo = sc.nextLine();
            al.setGrupo(grupo);
            
        do{
            
            System.out.println("Inserte la fecha de nacimiento del alumno (dd-mm-aaaa): ");
            System.out.print("> ");
            fecha = sc.nextLine();
            String separado[] = fecha.split("-");

            for(int i = separado.length; i>0; i--){
                if(separado[i-1].length()==4){
                    fecha = separado[i-1] + "-";
                    añoValido = true;
                }else if(añoValido && i==2 && separado[i-1].length()==2 && Integer.parseInt(separado[i-1])>=1 || Integer.parseInt(separado[i-1]) <=12){
                        mesValido = true;
                        fecha += separado[i-1]+"-";
                }else if(mesValido && i==1 && separado[i-1].length()==2 && Integer.parseInt(separado[i-1])>=1 || Integer.parseInt(separado[i-1]) <=31){
                        diaValido = true;
                        dia = separado[i-1];
                        fecha += separado[i-1];
                    }
            }
        }while(!diaValido);
            
            Date date = Date.valueOf(fecha);
            al.setFechaNacimiento(date);
            
            
            session.save(al);
            tx.commit();
            
            session.close();
            sesion.close();
    }
    
}
