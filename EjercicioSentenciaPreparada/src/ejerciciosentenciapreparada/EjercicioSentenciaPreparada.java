package ejerciciosentenciapreparada;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjercicioSentenciaPreparada {

   public static void main(String[] args){
        
        try{
            Scanner tec = new Scanner(System.in);
             Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto1", "root", "");
            System.out.println("Hemos hecho la conexión con la base de datos");
            Statement sentencia= conexion.createStatement();
            ResultSet resul;
            
            PreparedStatement sentenciaAlumno = conexion.prepareStatement("INSERT INTO alumno VALUES(?,?,?,?,?)");
            PreparedStatement sentenciaCiclo = conexion.prepareStatement("INSERT INTO ciclo VALUES(?,?,?)");
            PreparedStatement sentenciaModulo = conexion.prepareStatement("INSERT INTO modulo VALUES(?,?,?,?,?)");
            PreparedStatement sentenciaProfesor = conexion.prepareStatement("INSERT INTO profesor VALUES(?,?,?)");
            PreparedStatement sentenciaAlumnoModulo = conexion.prepareStatement("INSERT INTO alumno_modulo VALUES(?,?,?)");
            
            System.out.println("Selecciona nombre tabla: ");
            String nombre = tec.nextLine();
            
            switch(nombre){
                case "alumno":
                    resul = sentencia.executeQuery("SHOW COLUMNS FROM "+nombre);
                    int cont1 =1;
                    while (resul.next()) {
                    System.out.println(resul.getString(1) + " " + resul.getString(2));
                    
                    if(resul.getString(2).equals("date")){
                        String fecha=tec.nextLine();
                        Date date = Date.valueOf(fecha);
                        sentenciaAlumno.setDate(cont1, date);
                    }else{
                        String valor=tec.nextLine();
                        sentenciaAlumno.setString(cont1, valor);
                    }
                   
                    cont1++;
                    }
                    sentenciaAlumno.executeUpdate();
                    sentenciaAlumno.close();
                    break;
                case "profesor":
                    resul = sentencia.executeQuery("SHOW COLUMNS FROM "+nombre);
                    int cont2 = 1;
                    while (resul.next()) {
                    System.out.println(resul.getString(1) + " " + resul.getString(2));
                    String valor2=tec.nextLine();
                    sentenciaProfesor.setString(cont2, valor2);
                    cont2++;
                    }
                    sentenciaProfesor.executeUpdate();
                    sentenciaProfesor.close();
                    break;
                case "ciclo":
                    resul = sentencia.executeQuery("SHOW COLUMNS FROM "+nombre);
                    int cont3 = 1;
                    while (resul.next()) {
                    System.out.println(resul.getString(1) + " " + resul.getString(2));
                    String valor3=tec.nextLine();
                    sentenciaCiclo.setString(cont3, valor3);
                    cont3++;
                    }
                    sentenciaCiclo.executeUpdate();
                    sentenciaCiclo.close();
                    break;
                case "modulo":
                    int cont4 = 1;
                    resul = sentencia.executeQuery("SHOW COLUMNS FROM "+nombre);
                    cont4 =1;
                    while (resul.next()) {
                    System.out.println(resul.getString(1) + " " + resul.getString(2));
                    String valor4=tec.nextLine();
                    sentenciaModulo.setString(cont4, valor4);
                    cont4++;
                    }
                    sentenciaModulo.executeUpdate();
                    sentenciaModulo.close();
                    break;
                    
                    case "alumno_modulo":
                    resul = sentencia.executeQuery("SHOW COLUMNS FROM "+nombre);
                    int cont5 = 1;
                    while (resul.next()) {
                    System.out.println(resul.getString(1) + " " + resul.getString(2));
                    if(resul.getString(2).equals("int")){
                        int nota= Integer.parseInt(tec.nextLine());
                        sentenciaAlumnoModulo.setInt(cont5, nota);
                    }else{
                        String valor=tec.nextLine();
                        sentenciaAlumnoModulo.setString(cont5, valor);
                    }
                    cont5++;
                    }
                    sentenciaAlumnoModulo.executeUpdate();
                    sentenciaAlumnoModulo.close();
                    break;
                default:
                    System.out.println("Esa tabla no existe");
                    break;
                    
            }
            conexion.close();
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Driver no encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioSentenciaPreparada.class.getName()).log(Level.SEVERE, null, ex);
      
    }
   }
    
}
