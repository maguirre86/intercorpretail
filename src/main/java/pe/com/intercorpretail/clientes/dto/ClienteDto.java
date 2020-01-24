package pe.com.intercorpretail.clientes.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDto {

    private String nombre;
    private String apellido;
    private Integer edad;
    @JsonFormat(shape = JsonFormat.Shape.SCALAR, pattern = "dd-MM-yyyy", locale = "es-AR", timezone = "America/Argentina" )
    private Date fechaNacimiento;

    public ClienteDto(){
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
