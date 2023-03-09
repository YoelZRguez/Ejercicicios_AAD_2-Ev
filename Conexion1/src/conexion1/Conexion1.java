
package conexion1;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion1 {

    public static void main(String[] args) {
        // Cargar driver
        Scanner sc = new Scanner (System.in);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Se ha cargado el driver con exito");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto1","root","");
            System.out.println("Nos hemos conectado con exito");
            Statement sentencia = conexion.createStatement();
            Statement sentencia2 = conexion.createStatement();
            String sql = "SELECT * FROM alumno LIMIT 3";
            
            ResultSet result = sentencia.executeQuery(sql);
            while (result.next()){
                System.out.println(result.getString("cod_alumno")+" "+result.getString("nombre_alumno")+" "+result.getString("grupo"));
                
                System.out.println("Inserta un nuevo grupo para el siguiente alumno: ");
                String grupo = sc.nextLine();
                
                String sql2 = "UPDATE alumno set grupo='"+grupo+"' WHERE cod_alumno='"+result.getString("cod_alumno")+"'";
                sentencia2.executeUpdate(sql2);
            }
            
            /*sentencia.executeUpdate("Insert into alumno (cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo) values('37', 'Pepe', 'Lopez', '1985-03-03', 'A')");
            Insertar alumno a la base de datos*/
            /*sentencia.executeUpdate("Update alumno set grupo='A' where grupo='B'");//Cambiar valores de la base de datos
            */
            
            sentencia.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error conexion");
        } catch (ClassNotFoundException ex) {
           System.out.println("Error al crear");
        }
    }
    
}
