package cl.hdd.certamen1.services;

import cl.hdd.certamen1.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculasServiceImpl implements PeliculasService {

    private static List<Pelicula> peliculas = new ArrayList<>();
    @Override
    public Pelicula create(Pelicula pelicula) {
        peliculas.add(pelicula);
        return pelicula;
    }

    @Override
    public List<Pelicula> getAll() {
        return peliculas;
    }

    @Override
    public List<Pelicula> filterLimite(String limite) {
        return peliculas;

    }
}
