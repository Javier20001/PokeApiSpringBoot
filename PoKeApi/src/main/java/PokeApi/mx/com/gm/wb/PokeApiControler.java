package PokeApi.mx.com.gm.wb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import PokeApi.mx.com.gm.domain.Pokemon;
import PokeApi.mx.com.gm.domain.stat.PokemonStats;
import PokeApi.mx.com.gm.service.PokemonService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PokeApiControler {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/")
    public static String inicio(){
        return "index";
    }

    @GetMapping("/traer")
    public String traerPersonas(String nombre , Model model){
        Pokemon p = pokemonService.traerPokemon(nombre);
        for (PokemonStats stats : p.getStats()) {
            stats.getStat().abrebiatura(stats.getStat().getName());
        }
        // p.getAbilities().get(0).getAbility().getEffect_entries().get(1).getShort_effect()
        model.addAttribute("Pokemon", p);
        return "index";
    }

}
