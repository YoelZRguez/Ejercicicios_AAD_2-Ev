
package aniadiralumno_hibermate;

import java.sql.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AñadirAlumno_Hibermate {
    Scanner sc = new Scanner (System.in);
    SessionFactory sesion;
    Session session;
    Transaction tx;
    
    public AñadirAlumno_Hibermate(){
            sesion= HibernateUtil.getSessionFactory();
            session=sesion.openSession();
            tx=session.beginTransaction();
    }
    
    public static void main(String[] args) {
        AñadirAlumno_Hibermate a = new AñadirAlumno_Hibermate();
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
                + "\n1. Añadir fila a la tabla alumno (Introduciendo datos por teclado)"
                + "\n2. Borrar elemento de la tabla alumno (Introduciendo código por teclado)"
                + "\n3. Actualizar un registro de la tabla profesor (Introduciendo datos por teclado)"
                + "\n4. Mostrar por pantalla los datos del cod_alumno que introducimos por teclado"
                + "\n0. Salir");
        System.out.print("> ");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------------------------------------------------------");
        return opcion;
    }
    
    private void procesarOpcion(int opcion){
        switch (opcion){
                case 1: 
                    añadirFilaAlumno();
                    break;
                    
                case 2: 
                    borrarElementoAlumno();
                    break;
                    
                case 3: 
                    actualizarProfesor();
                    break;
                    
                case 4:
                    mostrarDatosAlumno();
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
    
    
    private void añadirFilaAlumno(){
    Alumno al = new Alumno();
    
        System.out.println("Introducimos un alumno: ");
        System.out.println("");
        
        System.out.println("Inserte el cod_alumno: ");
        System.out.print("> ");
        String cod_alumno = sc.nextLine();
        
        System.out.println("Inserte el nombre: ");
        System.out.print("> ");
        String nombre = sc.nextLine();
        
        
        System.out.println("Inserte los apellidos: ");
        System.out.print("> ");
        String apellidos = sc.nextLine();
    
    
        System.out.println("Inserte la fecha de nacimiento: ");
        System.out.print("> ");
        String fecha = sc.nextLine();
        Date date = Date.valueOf(fecha);
        
        System.out.println("Inserte el grupo: ");
        System.out.print("> ");
        String grupo = sc.nextLine();
        
        al.setCodAlumno(cod_alumno);
        al.setNombreAlumno(nombre);
        al.setApellidosAlumno(apellidos);
        al.setFechaNacimiento(date);
        al.setGrupo(grupo);
        
        session.save(al);
        tx.commit();
        
    }
    
    private void borrarElementoAlumno (){
        
        
        System.out.println("Introduce el código del alumno que quieras borrar: ");
        String cod_alumno = sc.nextLine();
        Alumno al = new Alumno(cod_alumno);
        session.delete(al);
        tx.commit();
        
    }
    
    private void actualizarProfesor(){
        System.out.println("Introduce el cod_profesor que deseas editar: ");
        System.out.print("> ");
        String cod_profesor = sc.nextLine();
        
        Profesor pro = new Profesor(cod_profesor);
        System.out.println("Introduce el nuevo nombre del profesor: ");
        System.out.print("> ");
        String nombre = sc.nextLine();
        pro.setNombreProfesor(nombre);
        
        
        System.out.println("Introduce la nueva ciudad del profesor: ");
        String ciudad = sc.nextLine();
        pro.setCiudad(ciudad);
        
        session.update(pro);
        tx.commit();
    }
    
    private void mostrarDatosAlumno(){
        
        System.out.println("Introduce el cod_alumno para ver sus datos: ");
        System.out.print("> ");
        String cod_alumno = sc.nextLine();
        
        Alumno al;
        al = (Alumno) session.get(Alumno.class, String.valueOf(cod_alumno));
        
        System.out.println("Código del alumno: "+cod_alumno);
        System.out.println("Nombre del alumno: "+al.getNombreAlumno());
        System.out.println("Apellidos del alumno: "+al.getApellidosAlumno());
        System.out.println("Fecha de nacimiento: "+al.getFechaNacimiento());
        System.out.println("Grupo: "+al.getGrupo());
        
        
        
        
    }
    
    
}
