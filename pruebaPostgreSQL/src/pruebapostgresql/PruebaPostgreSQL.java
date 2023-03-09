
package pruebapostgresql;

import java.sql.*;
import java.util.Scanner;


public class PruebaPostgreSQL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Cargar driver
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Se ha cargado el driver con exito");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost/instituto2","postgres","admin");
            System.out.println("Nos hemos conectado con exito a instituto2");
            Statement sentencia = conexion.createStatement();
            
            
            ResultSet result = sentencia.executeQuery("SELECT * FROM profesor WHERE cod_profesor='01' or cod_profesor='02' or cod_profesor='03'"
            /*"WHERE nombre_profesor LIKE 'A%'"
            + "or nombre_profesor LIKE 'E%'"
            + "or nombre_profesor LIKE 'I%'"
            + "or nombre_profesor LIKE 'O%'"
            + "or nombre_profesor LIKE 'U%'"*/);
            
            
                  
            while (result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2)+" "
                        + "  "+result.getString(3));
            }
            System.out.println("-------------------------------------------------------------");
            for(int i= 1; i<=3; i++){
                System.out.print("Introduce una ciudad para el profesor con código 0"+i+": ");
                String ciudad = sc.nextLine();
                sentencia.executeUpdate("UPDATE profesor set ciudad='"+ciudad+"' WHERE cod_profesor ='0"+i+"'");
                System.out.println("---------------------------------------------------------");
            }
            
            System.out.println("¡Actualizado!");
            result = sentencia.executeQuery("SELECT * FROM PROFESOR WHERE cod_profesor='01' or cod_profesor='02' or cod_profesor='03'");
            while (result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2)+" "
                        + "  "+result.getString(3));
            }
            
            sentencia.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error SQL: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
           System.out.println("Error al crear");
        }
    }
    
}