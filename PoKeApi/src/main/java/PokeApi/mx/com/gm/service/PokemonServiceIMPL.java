package PokeApi.mx.com.gm.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.AbstractMap;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import PokeApi.mx.com.gm.domain.Pokemon;
import PokeApi.mx.com.gm.domain.ability.Ability;
import PokeApi.mx.com.gm.domain.ability.PokemonAbilities;
import PokeApi.mx.com.gm.domain.type.PokemonTypes;

@Service
public class PokemonServiceIMPL implements PokemonService {

    private static HttpClient httpcliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    Map<String, String> pokemonTypeColor = Stream.of(
            new AbstractMap.SimpleEntry<>("bug", "#ace600"),
            new AbstractMap.SimpleEntry<>("dark", "#604020"),
            new AbstractMap.SimpleEntry<>("dragon", "#944dff"),
            new AbstractMap.SimpleEntry<>("ghost", "#7733ff"),
            new AbstractMap.SimpleEntry<>("rock", "#cc9900"),
            new AbstractMap.SimpleEntry<>("psychic", "#ff4da6"),
            new AbstractMap.SimpleEntry<>("flying", "#d580ff"),
            new AbstractMap.SimpleEntry<>("ground", "#ffd966"),
            new AbstractMap.SimpleEntry<>("poison", "#b800e6"),
            new AbstractMap.SimpleEntry<>("fighting", "#b30000"),
            new AbstractMap.SimpleEntry<>("ice", "#66ffff"),
            new AbstractMap.SimpleEntry<>("grass", "#00e600"),
            new AbstractMap.SimpleEntry<>("electric", "#e6e600"),
            new AbstractMap.SimpleEntry<>("water", "#00aaff"),
            new AbstractMap.SimpleEntry<>("fire", "#ff6600"),
            new AbstractMap.SimpleEntry<>("fairy", "#ff99cc"),
            new AbstractMap.SimpleEntry<>("steel", "#8c8c8c"),
            new AbstractMap.SimpleEntry<>("normal", "#85adad"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @Override
    public Pokemon traerPokemon(String valor) {
        valor = valor.replace(" ", "");
        Pokemon p = null;
        final HttpRequest requestPost = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + valor)).build();
        try {
            final HttpResponse<String> response = httpcliente.send(requestPost, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            p = gson.fromJson(response.body(), Pokemon.class);
            setColorToPokemon(p);
            setAbilities(p);
            // System.out.println(p.getAbilities());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return p;
    }

    private void setColorToPokemon(Pokemon pokemon) {
        pokemonTypeColor.forEach((key, value) -> {
            for (PokemonTypes pokemonType : pokemon.getTypes()) {
                if (pokemonType.getType().getName().equals(key)) {
                    pokemonType.getType().setColor(value);
                }
            }
        });

        pokemon.setColor(pokemon.getTypes().get(0).getType().getColor());
    }

    private void setAbilities(Pokemon p) {
        Ability ability = null;
        for (PokemonAbilities Pokemon_ability : p.getAbilities()) {
            final HttpRequest requestPost = HttpRequest.newBuilder().GET()
                    .uri(URI.create(Pokemon_ability.getAbility().getUrl())).build();
            try {
                final HttpResponse<String> response = httpcliente.send(requestPost,
                        HttpResponse.BodyHandlers.ofString());
                Gson gson = new Gson();
                Pokemon_ability.setAbility(gson.fromJson(response.body(), Ability.class));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
