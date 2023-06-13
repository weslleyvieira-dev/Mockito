package org.ufc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do Pokémon: ");
        String pokemonName = scanner.nextLine();
        scanner.close();

        PokemonApiClient pokemonApiClient = new PokemonApiClient();
        PokemonController pokemonController = new PokemonController(pokemonApiClient);

        String pokemonData = pokemonController.getPokemonData(pokemonName);
    }
}