package PokeApi.mx.com.gm.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import PokeApi.mx.com.gm.domain.Pokemon;

@Service
public class PokemonServiceIMPL implements PokemonService {

    private static HttpClient httpcliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    @Override
    public Pokemon traerPokemon(String valor) {
        Pokemon p = null;
        final HttpRequest requestPost = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + valor)).build();
        try {
            final HttpResponse<String> response = httpcliente.send(requestPost, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            p = gson.fromJson(response.body(), Pokemon.class);
            System.out.println(p.getStats());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return p;
    }

}
