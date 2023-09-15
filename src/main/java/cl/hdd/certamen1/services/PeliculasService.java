package cl.hdd.certamen1.services;

import cl.hdd.certamen1.entities.Pelicula;

import java.util.List;

public interface PeliculasService {

    Pelicula create(Pelicula pelicula);

    List<Pelicula> getAll();

    List<Pelicula> filterLimite(String limite);

}
