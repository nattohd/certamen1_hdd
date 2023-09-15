package cl.hdd.certamen1.controllers;

import cl.hdd.certamen1.entities.Pelicula;
import cl.hdd.certamen1.services.PeliculasService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculasController {
    @Autowired
    private PeliculasService peliculasService;

    private boolean isLimiteValid(String limite){
        String limite1 = "Menor_edad".toLowerCase();
        String limite2= "Menor_edad".toLowerCase();
        String limite3= "Mayor".toLowerCase();

        return limite1.equalsIgnoreCase(limite)||
                limite2.equalsIgnoreCase(limite)||
                limite3.equalsIgnoreCase(limite);
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<Pelicula> create(@RequestBody Pelicula pelicula){

        try{
            return ResponseEntity.ok().body(this.peliculasService.create(pelicula));
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/verPeliculas")
    public ResponseEntity<List<Pelicula>> getAll(){
        try {
            return ResponseEntity.ok(this.peliculasService.getAll());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/verPeliculas/{limite}")
    public ResponseEntity<List<Pelicula>> filterLimite(@PathVariable String limite) {
        if(!isLimiteValid(limite)){
            return ResponseEntity.badRequest().build();
        }
        List<Pelicula> peliculasFiltro = new ArrayList<>();
        switch (limite.toLowerCase()) {
            case "menor_edad":
                for (Pelicula pelicula : this.peliculasService.getAll()) {
                    if (pelicula.getEdadMin() <= 15) {
                        peliculasFiltro.add(pelicula);
                    }
                }
                break;
            case "adolescentes":
                for (Pelicula pelicula : this.peliculasService.getAll()) {
                    if (pelicula.getEdadMin() > 15 && pelicula.getEdadMin() < 18) {
                        peliculasFiltro.add(pelicula);
                    }
                }
                break;
            case "mayor":
                for (Pelicula pelicula : this.peliculasService.getAll()) {
                    if (pelicula.getEdadMin() >= 18) {
                        peliculasFiltro.add(pelicula);
                    }
                }
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(peliculasFiltro);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }



}
