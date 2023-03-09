package hibernate1;
// Generated 16-ene-2023 20:33:33 by Hibernate Tools 4.3.1



/**
 * AlumnoModulo generated by hbm2java
 */
public class AlumnoModulo  implements java.io.Serializable {


     private AlumnoModuloId id;
     private Alumno alumno;
     private Modulo modulo;
     private Integer nota;

    public AlumnoModulo() {
    }

	
    public AlumnoModulo(AlumnoModuloId id, Alumno alumno, Modulo modulo) {
        this.id = id;
        this.alumno = alumno;
        this.modulo = modulo;
    }
    public AlumnoModulo(AlumnoModuloId id, Alumno alumno, Modulo modulo, Integer nota) {
       this.id = id;
       this.alumno = alumno;
       this.modulo = modulo;
       this.nota = nota;
    }
   
    public AlumnoModuloId getId() {
        return this.id;
    }
    
    public void setId(AlumnoModuloId id) {
        this.id = id;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Modulo getModulo() {
        return this.modulo;
    }
    
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    public Integer getNota() {
        return this.nota;
    }
    
    public void setNota(Integer nota) {
        this.nota = nota;
    }




}


