package org.test;

import org.ufc.PokemonApiClient;
import org.ufc.PokemonController;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class PokemonApiClientMockito {
    public static void main(String[] args) {
        PokemonApiClient pokemonApiClient = Mockito.mock(PokemonApiClient.class);
        PokemonController pokemonController = new PokemonController(pokemonApiClient);

        // Definindo o comportamento simulado da classe mock
        try {
            when(pokemonApiClient.getPokemonData(anyString())).thenReturn("Dados simulados do Pokémon");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // Chamando o método da classe controladora que utiliza a classe mock
        pokemonController.getPokemonData("ditto");
    }
}
