package cl.hdd.certamen1.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pelicula {
    private String nombre;
    private String nombreAbreviado;
    private int edadMin;
    private String genero;

}
