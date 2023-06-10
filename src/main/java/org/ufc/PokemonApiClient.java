package org.ufc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class PokemonApiClient {
    public String getPokemonData(String pokemonName) throws IOException, URISyntaxException {
        URI uri = new URI("https", "pokeapi.co", "/api/v2/pokemon/" + pokemonName, null);
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();
            return response.toString();
        } else {
            throw new IOException("Error retrieving Pokemon data. Response code: " + responseCode);
        }
    }
}
