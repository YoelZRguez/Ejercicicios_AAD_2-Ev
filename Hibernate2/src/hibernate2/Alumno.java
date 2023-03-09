package hibernate2;
// Generated 25-ene-2023 19:59:29 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private String codAlumno;
     private String nombreAlumno;
     private String apellidosAlumno;
     private Date fechaNacimiento;
     private String grupo;
     private Set alumnoModulos = new HashSet(0);

    public Alumno() {
    }

	
    public Alumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }
    public Alumno(String codAlumno, String nombreAlumno, String apellidosAlumno, Date fechaNacimiento, String grupo, Set alumnoModulos) {
       this.codAlumno = codAlumno;
       this.nombreAlumno = nombreAlumno;
       this.apellidosAlumno = apellidosAlumno;
       this.fechaNacimiento = fechaNacimiento;
       this.grupo = grupo;
       this.alumnoModulos = alumnoModulos;
    }
   
    public String getCodAlumno() {
        return this.codAlumno;
    }
    
    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }
    public String getNombreAlumno() {
        return this.nombreAlumno;
    }
    
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public String getApellidosAlumno() {
        return this.apellidosAlumno;
    }
    
    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public Set getAlumnoModulos() {
        return this.alumnoModulos;
    }
    
    public void setAlumnoModulos(Set alumnoModulos) {
        this.alumnoModulos = alumnoModulos;
    }




}


