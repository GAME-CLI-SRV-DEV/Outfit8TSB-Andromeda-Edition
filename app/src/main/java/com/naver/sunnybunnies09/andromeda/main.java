package com.naver.sunnybunnies09.andromeda;

import java.net.URISyntaxException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URL;
import java.net.URI;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        boolean mapper = false; // You need to declare this variable

        System.out.println("Welcome to My MUD PC CBBS!");
        System.out.println("Type 'andromeda' to start the adventure!");

        try {
            URL url = new URL("https://api.ip.pe.kr/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response4 = reader.readLine();
            reader.close();

            System.out.println("make your own IPv4 server with " + response4 + ":XXXXX.andromeda.sunnybunnies09.game domain!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("oh no! your IPv6 is not supported! You can have only [:::]:XXXXX.andromeda.sunnybunnies09.game like domain! if you want 0.0.0.0:XXXXX.andromeda.sunnybunnies09.game like domain, Contact your ISP to give you IPv4.");
            System.out.println("However, please note: Portforward is not available for IPv6 on LG U+ because they are inside NAT Option! to resolve this, you need ngrok as a temp alternative.");
            System.out.println("also, you don't have to portforward as External and Internal is same IP on IPv6.");
        }
        try {
            URL url = new URL("https://api6.ipify.org/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response4 = reader.readLine();
            reader.close();

            System.out.println("make your own IPv4 server with [" + response4 + "]:XXXXX.andromeda.sunnybunnies09.game domain!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("oh no! your IPv6 is not supported! You can have only [:::]:XXXXX.andromeda.sunnybunnies09.game like domain! if you want 0.0.0.0:XXXXX.andromeda.sunnybunnies09.game like domain, Contact your ISP to give you IPv4.");
            System.out.println("However, please note: Portforward is not available for IPv6 on LG U+ because they are inside NAT Option! to resolve this, you need ngrok as a temp alternative.");
            System.out.println("also, you don't have to portforward as External and Internal is same IP on IPv6.");
        }

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                if (input.equals("map")) {
                    System.out.println("map: type your ip to display your map. this will flash a map on the map and generate a map based off the api and the server. if is survival, this game will be generating trees and more!");
                    System.out.println("if the game type is creative, this game will be only generating MUD styled system.");
                    mapper = true;
                    while (mapper) {
                        System.out.print("* ");
                        String map = scanner.nextLine().toLowerCase();
                        System.out.print("P* ");
                        String port = scanner.nextLine().toLowerCase();
                        System.out.println("https://api." + map + ":" + port + ".andromeda.sunnybunnies09.game: CONNECT");
                        try {
                            URL url = new URL("https://api." + map + ":" + port + ".andromeda.sunnybunnies09.game");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");

                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            String responsenet = reader.readLine();
                            reader.close();

                            System.out.println(responsenet);
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Fatal! cannot connect to api server, cannot fetch a map.");
                        }
                    }
                } else {
                    System.out.println("Unknown command.");
                }
            }
        }


        scanner.close();
    }
}

