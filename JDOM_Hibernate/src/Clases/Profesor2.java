package Clases;
// Generated 13-mar-2023 19:13:49 by Hibernate Tools 4.3.1



/**
 * Profesor2 generated by hbm2java
 */
public class Profesor2  implements java.io.Serializable {


     private String codProfesor;
     private String nombreProfesor;
     private String ciudad;

    public Profesor2() {
    }

    public Profesor2(String codProfesor, String nombreProfesor, String ciudad) {
       this.codProfesor = codProfesor;
       this.nombreProfesor = nombreProfesor;
       this.ciudad = ciudad;
    }
   
    public String getCodProfesor() {
        return this.codProfesor;
    }
    
    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }
    public String getNombreProfesor() {
        return this.nombreProfesor;
    }
    
    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }




}


