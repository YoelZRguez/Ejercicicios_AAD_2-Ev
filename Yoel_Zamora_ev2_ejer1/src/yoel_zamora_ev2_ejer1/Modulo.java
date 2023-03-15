package yoel_zamora_ev2_ejer1;
// Generated 15-mar-2023 19:12:49 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Modulo generated by hbm2java
 */
public class Modulo  implements java.io.Serializable {


     private String codModulo;
     private Ciclo ciclo;
     private Profesor profesor;
     private String nombreModulo;
     private String curso;
     private Set alumnoModulos = new HashSet(0);

    public Modulo() {
    }

	
    public Modulo(String codModulo) {
        this.codModulo = codModulo;
    }
    public Modulo(String codModulo, Ciclo ciclo, Profesor profesor, String nombreModulo, String curso, Set alumnoModulos) {
       this.codModulo = codModulo;
       this.ciclo = ciclo;
       this.profesor = profesor;
       this.nombreModulo = nombreModulo;
       this.curso = curso;
       this.alumnoModulos = alumnoModulos;
    }
   
    public String getCodModulo() {
        return this.codModulo;
    }
    
    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }
    public Ciclo getCiclo() {
        return this.ciclo;
    }
    
    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public String getNombreModulo() {
        return this.nombreModulo;
    }
    
    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }
    public String getCurso() {
        return this.curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Set getAlumnoModulos() {
        return this.alumnoModulos;
    }
    
    public void setAlumnoModulos(Set alumnoModulos) {
        this.alumnoModulos = alumnoModulos;
    }




}


