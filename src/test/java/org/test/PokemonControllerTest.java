package org.test;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import org.ufc.PokemonApiClient;
import org.ufc.PokemonController;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class PokemonControllerTest {

    @Test
    public void testGetPokemonData_Success() throws IOException, URISyntaxException {
        // Criação do mock para PokemonApiClient
        PokemonApiClient pokemonApiClient = Mockito.mock(PokemonApiClient.class);

        // Configuração do comportamento do mock
        String responseData = "Dados simulados do Pokémon";
        when(pokemonApiClient.getPokemonData("ditto")).thenReturn(responseData);

        // Criação do objeto sob teste
        PokemonController pokemonController = new PokemonController(pokemonApiClient);

        // Execução do método a ser testado
        pokemonController.getPokemonData("ditto");

        // Verificação do comportamento esperado
        verify(pokemonApiClient, times(1)).getPokemonData("ditto");
        // Faça outras verificações necessárias para os dados obtidos
    }

    @Test
    public void testGetPokemonData_Failure() throws IOException, URISyntaxException {
        // Criação do mock para PokemonApiClient
        PokemonApiClient pokemonApiClient = Mockito.mock(PokemonApiClient.class);

        // Configuração do comportamento do mock
        when(pokemonApiClient.getPokemonData("unknown")).thenThrow(new IOException("Pokemon not found"));

        // Criação do objeto sob teste
        PokemonController pokemonController = new PokemonController(pokemonApiClient);

        // Execução do método a ser testado
        pokemonController.getPokemonData("unknown");

        // Verificação do comportamento esperado
        verify(pokemonApiClient, times(1)).getPokemonData("unknown");
        // Faça outras verificações necessárias para o tratamento de erro
    }
}
