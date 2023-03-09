package hibernatehql;
// Generated 08-feb-2023 19:39:16 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Profesor generated by hbm2java
 */
public class Profesor  implements java.io.Serializable {


     private String codProfesor;
     private String nombreProfesor;
     private String ciudad;
     private Set modulos = new HashSet(0);

    public Profesor() {
    }

	
    public Profesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }
    public Profesor(String codProfesor, String nombreProfesor, String ciudad, Set modulos) {
       this.codProfesor = codProfesor;
       this.nombreProfesor = nombreProfesor;
       this.ciudad = ciudad;
       this.modulos = modulos;
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
    public Set getModulos() {
        return this.modulos;
    }
    
    public void setModulos(Set modulos) {
        this.modulos = modulos;
    }




}


