package org.ufc;

public class Main {
    public static void main(String[] args) {
        PokemonApiClient pokemonApiClient = new PokemonApiClient();
        PokemonController pokemonController = new PokemonController(pokemonApiClient);
        pokemonController.getPokemonData("ditto");
    }
}