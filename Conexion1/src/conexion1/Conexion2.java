
package conexion1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion2 {

    public static void main(String[] args) {
        // Cargar driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Se ha cargado el driver con exito");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto1","root","");
            System.out.println("Nos hemos conectado con exito");
            Statement sentencia = conexion.createStatement();
            /*sentencia.executeUpdate("Insert into alumno (cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo) values('37', 'Pepe', 'Lopez', '1985-03-03', 'A')");
            Insertar alumno a la base de datos*/
            sentencia.executeUpdate("Update alumno set grupo='A' where grupo='B'");//Cambiar valores de la base de datos
            ResultSet result = sentencia.executeQuery("Select * from alumno");
            while (result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2));
            }
            sentencia.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error conexion");
        } catch (ClassNotFoundException ex) {
           System.out.println("Error al crear");
        }
    }
    
}