package com.graphhopper.api;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final String apiKey = "573ef65b-4b67-44ad-8941-0e8ced5775cb";

    static List<Trajet> trajets = new ArrayList<>();
    static List<Adresse> adresses = new ArrayList<>();
    static OkHttpClient client = new OkHttpClient();

    static String run(String urlRoute) throws IOException {
        Request request = new Request.Builder()
                .url(urlRoute)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    static double[] geocode(String ville) throws IOException {
        String url = "https://graphhopper.com/api/1/geocode?q="
                + ville.replace(" ", "+")
                + "&key=" + apiKey;
        String resultat = run(url);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(resultat);

        double lat = root.get("hits").get(0).get("point").get("lat").asDouble();
        double lon = root.get("hits").get(0).get("point").get("lng").asDouble();

        return new double[]{lat, lon};
    }

    public static void main(String... args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Publier un trajet");
            System.out.println("2. Rechercher un trajet");
            System.out.println("3. Quitter");
            System.out.println("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {

                System.out.println("Ville de depart : ");
                String ville = scanner.nextLine();

                System.out.println("Ville de destination : ");
                String destination = scanner.nextLine();

                System.out.println("Nombre de place : ");
                int places = scanner.nextInt();
                scanner.nextLine();

                String transport = "car";

                double[] coordDepart = geocode(ville);
                double[] coordDestination = geocode(destination);

                String urlRoute = "https://graphhopper.com/api/1/route"
                        + "?point=" + coordDepart[0] + "," + coordDepart[1]
                        + "&point=" + coordDestination[0] + "," + coordDestination[1]
                        + "&profile=" + transport
                        + "&key=" + apiKey;

                String resultat = run(urlRoute);
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(resultat);

                double distance = root.get("paths").get(0).get("distance").asDouble();
                long durée = root.get("paths").get(0).get("time").asLong();

                System.out.println("Distance : " + distance / 1000 + " km");
                System.out.println("Durée : " + durée / 60000 + " minutes");

                Trajet trajet = new Trajet(ville, destination, places, transport);
                trajets.add(trajet);
                System.out.println("Trajet publié !");

            } else if (choix == 2) {

                System.out.println("Ville de depart : ");
                String villeDepart = scanner.nextLine();

                System.out.println("Ville de destination : ");
                String villeDestination = scanner.nextLine();

                boolean trouve = false;
                for (Trajet t : trajets) {
                    if (t.getDepart().equals(villeDepart) && t.getDestination().equals(villeDestination)) {
                        System.out.println("Trajet trouvé !");
                        System.out.println("De : " + t.getDepart() + " à " + t.getDestination());
                        System.out.println("Places : " + t.getNombrePlaces());
                        System.out.println("Transport : " + t.getTransport());
                        trouve = true;
                    }
                }

                if (!trouve) {
                    System.out.println("Aucun trajet trouvé !");
                }

            } else {
                System.out.println("Au revoir !");
                break;
            }
        }
    }
}