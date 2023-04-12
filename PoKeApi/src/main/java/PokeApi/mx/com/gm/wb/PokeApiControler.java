package PokeApi.mx.com.gm.wb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.springframework.ui.Model;

import PokeApi.mx.com.gm.domain.Pokemon;
import PokeApi.mx.com.gm.domain.stat.PokemonStats;
import PokeApi.mx.com.gm.service.PokemonService;

@RestController
@RequestMapping("/Pokemon")
public class PokeApiControler {
    @Autowired
    private PokemonService pokemonService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Traer/{nombre}")
    public String traerPersonas(@PathVariable String nombre, Model model) {
        Pokemon p = pokemonService.traerPokemon(nombre);
        for (PokemonStats stats : p.getStats()) {
            stats.getStat().abrebiatura(stats.getStat().getName());
        }
        Gson gson = new Gson();
        return gson.toJson(p);
    }

}
