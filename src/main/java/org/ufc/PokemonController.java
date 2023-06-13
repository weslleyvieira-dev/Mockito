package org.ufc;

import java.io.IOException;
import java.net.URISyntaxException;

public class PokemonController {
    private PokemonApiClient pokemonApiClient;

    public PokemonController(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }

    public String getPokemonData(String pokemonName) {
        try {
            String data = pokemonApiClient.getPokemonData(pokemonName);
            System.out.println(data);
        } catch (IOException e) {
            System.out.println("Erro ao obter os dados do Pokémon: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return pokemonName;
    }
}